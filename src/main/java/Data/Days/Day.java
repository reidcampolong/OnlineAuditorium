package Data.Days;

import Data.Section.Seat.Seat;
import Data.Section.Seat.Status;
import Data.Section.Section;
import Data.Section.SectionHandler;
import Utilities.Log;
import View.HTMLBuilder;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Day {

    private Firestore db;
    private String databaseName;

    private Section leftSection, middleSection, rightSection;

    public Day(Firestore db, String databaseName) {
        this.db = db;
        this.databaseName = databaseName;
        leftSection = new Section(SectionHandler.sectionAValues[0], SectionHandler.sectionAValues[1], SectionHandler.sectionAValues[2]);
        middleSection = new Section(SectionHandler.sectionBValues[0], SectionHandler.sectionBValues[1], SectionHandler.sectionBValues[2]);
        rightSection = new Section(SectionHandler.sectionCValues[0], SectionHandler.sectionCValues[1], SectionHandler.sectionCValues[2]);
        initializeListeners();
    }

    public void initializeListeners() {
        initListener(leftSection);
        initListener(middleSection);
        initListener(rightSection);
    }

    private void initListener(Section section) {
        String sectionID = String.valueOf(section.getSectionNumber());
        CollectionReference collectionReference = db.collection("days").document(databaseName).collection(sectionID);
        collectionReference.addSnapshotListener((snapshots, e) -> {
            if (snapshots != null) {
                for (DocumentChange change : snapshots.getDocumentChanges()) {
                    Log.i("Received update " + change.getDocument().getId() + " " + change.getDocument().toString());
                    updateSeatByDoc(section, change.getDocument());
                }
            }
        });
    }

    private void updateSeatByDoc(Section section, QueryDocumentSnapshot document) {
        Log.i("Updating seat to " + document.getData().get("status").toString());
        Seat seat = section.getSeatByName(document.getId());
        Status status = Status.valueOf(document.getData().get("status").toString());
        String holder = document.getData().get("holder").toString();
        seat.changeStatus(status);
        seat.changeSeatHolder(holder);
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public Section getLeftSection() {
        return leftSection;
    }
    public Section getMiddleSection() {
        return middleSection;
    }
    public Section getRightSection() {
        return rightSection;
    }
}
