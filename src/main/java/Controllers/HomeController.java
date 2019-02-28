package Controllers;

import Data.Days.DayHandler;
import Data.Section.SectionHandler;
import View.HTMLBuilder;
import spark.*;

import java.util.HashMap;

public class HomeController {

    /**
     * Route to be served when called
     */
    public static Route serveRoute = new Route() {
        public Object handle(Request request, Response response) throws Exception {
            System.out.println("Handling new Home request");
            System.out.println("Time to render HTML");
            String dayname = request.queryParams("day");
            return HTMLBuilder.buildHTMLPage(DayHandler.getDay("thursday"));
            //return new ModelAndView(new HashMap(), "index.html", new HTMLTemplateEngine());
        }
    };
}
