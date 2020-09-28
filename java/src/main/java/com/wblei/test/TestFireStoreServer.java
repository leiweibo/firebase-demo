package com.wblei.test;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

public class TestFireStoreServer {

  public static void main(String[]args) throws IOException, ExecutionException,
      InterruptedException {
    // Use a service account
    InputStream serviceAccount = new FileInputStream("src/main/resources/playfirebase-58833-a0945921a733.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(credentials)
        .build();
    FirebaseApp.initializeApp(options);

    Firestore db = FirestoreClient.getFirestore();

    //// asynchronously retrieve all users
    //ApiFuture<QuerySnapshot> query = db.collection("user").get();
    //// ...
    //// query.get() blocks on response
    //QuerySnapshot querySnapshot = query.get();
    //List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    //for (QueryDocumentSnapshot document : documents) {
    //  System.out.println(document);
    //}



    CollectionReference users = db.collection("user");
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    calendar.set(Calendar.HOUR_OF_DAY, 19);
    calendar.set(Calendar.MINUTE, 28);
    calendar.set(Calendar.SECOND, 46);
    Query query = users.whereGreaterThan("updateTime", calendar.getTime());

    ApiFuture<QuerySnapshot> querySnapshot = query.get();

    for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
      System.out.println(document.getId());
    }
  }
}
