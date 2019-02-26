import Controllers.HomeController;
import Utilities.Path;
import spark.Spark;

public class Application {

    private static final int PORT = 4428;

    public static void main(String[] args) {
        Spark.port(PORT);

        // Create Home path leading to Home's Controller
        Spark.get(Path.HOME, HomeController.serveRoute);

        new WebServer();
    }
}
