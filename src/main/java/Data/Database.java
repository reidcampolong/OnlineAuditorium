package Data;

import Data.Days.DayHandler;
import Utilities.Log;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Database {

    private DayHandler dayHandler;
    private Firestore db;

    public Database() {
        initializeConnection();
    }

    private void initializeConnection() {
        Log.i("Creating database connection.");
        GoogleCredentials credentials = null;
        InputStream serviceAccount;
        try {
            Log.i("Attempting to create connection.");
            serviceAccount = getClass().getResourceAsStream("/account.json");
            credentials = GoogleCredentials.fromStream(serviceAccount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirestoreOptions options = FirestoreOptions.newBuilder().setCredentials(credentials).setTimestampsInSnapshotsEnabled(true).build();
        db = options.getService();

        this.dayHandler = new DayHandler(db);
        Log.i("Loading initial data");
        try {
            // TODO switch views to day
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
