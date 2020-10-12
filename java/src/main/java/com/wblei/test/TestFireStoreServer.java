package com.wblei.test;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

public class TestFireStoreServer {

  public static void main(String[]args) throws IOException, ExecutionException,
      InterruptedException {
    // Use a service account
    InputStream serviceAccount = TestFireStoreServer.class.getClassLoader().getResourceAsStream("playfirebase-58833-a0945921a733.json");
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



    CollectionReference users = db.collection("cookies");
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    calendar.set(Calendar.DAY_OF_MONTH, 9);
    calendar.set(Calendar.HOUR_OF_DAY, 16);
    calendar.set(Calendar.MINUTE, 11);
    calendar.set(Calendar.SECOND, 32);
    calendar.set(Calendar.MILLISECOND, 0);
    Query query = users.whereGreaterThanOrEqualTo("timestamp", calendar.getTime());

    ApiFuture<QuerySnapshot> querySnapshot = query.get();

    for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
      System.out.println(document.getId());
      CookieObject cookie = document.toObject(CookieObject.class);
      System.out.println(cookie);
    }
  }
}
