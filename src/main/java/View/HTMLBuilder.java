package View;

import Data.Days.Day;
import Data.Section.Seat.Seat;
import Data.Section.Seat.Status;
import Data.Section.Section;
import Data.Section.SectionHandler;
import Utilities.SeatTranslator;

public class HTMLBuilder {

    public static String buildHTMLPage(Day day) {
        System.out.println("Starting new builder");
        StringBuilder builder = new StringBuilder();
        System.out.println("A");
        builder.append("<html>  <head>\n" +
                getStyleTag() +
                "  </head>\n" +
                "  <body>");
        System.out.println("B");
        builder.append(buildHTMLForSection(day.getLeftSection()));
        System.out.println("C");
        builder.append("</body></html>");
        System.out.println("Built HTML");
        return builder.toString();
    }

    public static String buildHTMLForSection(Section section) {
        System.out.println("Building tag for section");
        StringBuilder builder = new StringBuilder();
        System.out.println("Builder initialized");
        builder.append(getTableTag(true));
        System.out.println("Tag appended");
        Seat[][] seatChart = section.getSeats();
        System.out.println("Loop time");
        for (int col = 0; col < seatChart.length; col++) {
            builder.append(getNewRowTag(true));
            for (int row = 0; row < seatChart[col].length; row++) {
                Seat seat = seatChart[col][row];
                builder.append("\n");
                builder.append(getSeatTag(seat));
            }
            builder.append(getNewRowTag(false));
        }
        builder.append(getTableTag(false));
        System.out.println("Finishedbuilding");
        return builder.toString();
    }

    private static String getStyleTag() {
        return "<style>th, td {\n" +
                "  text-align: center;\n" +
                "  width: 25px;\n" +
                "  height: 25px;\n" +
                "}\n" +
                "\n" +
                ".OCCUPIED {\n" +
                "  background-color: #f44242;\n" +
                "}\n" +
                "\n" +
                ".AVAILABLE {\n" +
                "  background-color: #00ff00;\n" +
                "}\n" +
                "\n" +
                ".BLACK {\n" +
                "  background-color: #6d6d6d;\n" +
                "}\n" +
                "\n" +
                ".HANDICAP {\n" +
                "  background-color: #0085FF;\n" +
                "}</style>\n";
    }

    private static String getSeatTag(Seat seat) {
        return "<td class = \"" + seat.getSeatStatus().toString() + "\">" + seat.getSectionTitle() + "</td>";
    }

    private static String getNewRowTag(boolean startTag) {
        return startTag ? "<tr>" : "</tr>";
    }

    private static String getTableTag(boolean startTag) {
        return startTag ? "<table>" : "</table>";
    }
}
