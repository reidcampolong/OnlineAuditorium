package Data.Section;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.HashMap;

/**
 * Created by Reid on 2/4/19.
 */
public class SectionHandler {

    private static HashMap<Integer, Section> sectionMap;
    public static int[] sectionAValues = {0, 29, 7};
    public static int[] sectionBValues = {1, 27, 14};
    public static int[] sectionCValues = {2, 29, 7};

    public SectionHandler() {
        sectionMap = new HashMap<>();
    }

    public void addSection(int sectionID, Section section ) {
        sectionMap.put(sectionID, section);
    }

    public static Section getSection(int sectionID) {
        return sectionMap.get(sectionID);
    }
}
