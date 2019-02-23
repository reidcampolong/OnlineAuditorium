import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class HomeController {

    private TemplateEngine engine;
    private HomeController(TemplateEngine engine) {
        this.engine =  engine;
    }

    public static Route serveRoute = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap();

        return null;
    };
