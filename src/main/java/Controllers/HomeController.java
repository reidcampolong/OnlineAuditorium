package Controllers;

import spark.Request;
import spark.Response;
import spark.Route;

public class HomeController {

    /**
     * Route to be served when called
     */
    public static Route serveRoute = new Route() {
        public Object handle(Request request, Response response) throws Exception {
            return "Hello";
        }
    };
}
