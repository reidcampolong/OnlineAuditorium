package Data.Days;

import com.google.cloud.firestore.Firestore;

import java.util.HashMap;

public class DayHandler {

    private Firestore db;
    private HashMap<String, Day> dayHashMap;

    public DayHandler(Firestore db) {
        this.db = db;
        dayHashMap = new HashMap(4);
        createDay("thursday");
        createDay("friday");
        createDay("satmat");
        createDay("satnight");
    }

    private void createDay(String dayname) {
        dayHashMap.put(dayname, new Day(db, dayname));
    }

    public Day requestDay(String dayname) {
        return dayHashMap.get(dayname);
    }
}
