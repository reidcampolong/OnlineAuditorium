import Data.Database;
import Data.Section.SectionHandler;

public class WebServer {

    private Database database;
    private SectionHandler sectionHandler;

    public WebServer() {
        sectionHandler = new SectionHandler();
        database = new Database();
    }
}
