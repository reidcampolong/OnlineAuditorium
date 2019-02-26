package Data.Section;

import Data.Section.Seat.Seat;
import Data.Section.Seat.Status;
import Utilities.SeatTranslator;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.HashMap;

/**
 * A section is a collection of seats with a set row and column count
 */
public class Section {

    private HashMap<String, Seat> seatNameMap;
    private int sectionNumber;
    private Seat[][] seats;

    public Section(int sectionNumber, int cols, int rows) {
        this.seatNameMap = new HashMap();
        this.sectionNumber = sectionNumber;
        this.initPane(cols, rows);
    }

    /**
     * Initializes pane with seat buttons
     *
     * @param cols
     * @param rows
     */
    private void initPane(int cols, int rows) {
        seats = new Seat[cols][rows];
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < seats[col].length; row++) {

                // Create seat
                Seat seat = new Seat(sectionNumber, SeatTranslator.getName(sectionNumber, cols, col, row), col, row, "None", Status.AVAILABLE);
                seatNameMap.put(seat.getSectionTitle(), seat);
                seats[col][row] = seat;
            }
        }
    }

    public Seat getSeatByName(String seatName) {
        return seatNameMap.get(seatName);
    }

    public Seat[][] getAllSeats() {
        return seats;
    }

    public Seat getSeatAtIndex(int x, int y) {
        return seats[x][y];
    }

    public int getSectionNumber() {
        return sectionNumber;
    }


}
