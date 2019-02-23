import spark.Spark;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.port;

public class Application {

    private static TemplateEngine templateEngine;
    private static final int PORT = 4428;

    public static void main(String[] args) {
        templateEngine = new FreeMarkerEngine();

        Spark.port(PORT);
        Spark.get(Path.HOME, HomeController.serveRoute());
    }
}
