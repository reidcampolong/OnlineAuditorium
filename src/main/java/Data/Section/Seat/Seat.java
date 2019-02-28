package Data.Section.Seat;

/**
 * A seat in our datastructure
 */
public class Seat {

    private int sectionNumber;
    private String sectionTitle;

    private int x, y;

    private Status seatStatus;
    private String seatHolder;

    /**
     * Constructs a new seat
     *
     * @param y          - column in section
     * @param x          - row in row
     * @param seatHolder
     * @param seatStatus
     */
    public Seat(int sectionNumber, String name, int y, int x, String seatHolder, Status seatStatus) {
        this.sectionNumber = sectionNumber;
        this.x = x;
        this.y = y;
        this.seatHolder = seatHolder;
        this.seatStatus = seatStatus;
        this.sectionTitle = name;
    }

    /**
     * Changes the seat status and updates the style
     *
     * @param newStatus
     */
    public void changeStatus(Status newStatus) {
        this.seatStatus = newStatus;
    }

    /**
     * Changes the seat holder
     *
     * @param newHolder
     */
    public void changeSeatHolder(String newHolder) {
        this.seatHolder = newHolder;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public String getSeatHolder() {
        return seatHolder;
    }

    public Status getSeatStatus() {
        return seatStatus;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

}
