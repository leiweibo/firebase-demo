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
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

public class TestFireStoreServer {

  public static void main(String[]args) throws IOException, ExecutionException,
      InterruptedException {
    // Use a service account
    //InputStream serviceAccount = TestFireStoreServer.class.getClassLoader().getResourceAsStream("playfirebase-58833-a0945921a733.json");
    InputStream serviceAccount = TestFireStoreServer.class.getClassLoader().getResourceAsStream("mobilecleaner-8126e-3445077f1b88.json");

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
    calendar.set(Calendar.DAY_OF_MONTH, 20);
    calendar.set(Calendar.HOUR_OF_DAY, 13);
    calendar.set(Calendar.MINUTE, 37);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    Query query = users.whereGreaterThanOrEqualTo("timestamp", calendar.getTime());

    ApiFuture<QuerySnapshot> querySnapshot = query.get();
    List<QueryDocumentSnapshot> documentSnapshots = querySnapshot.get().getDocuments();
    for (QueryDocumentSnapshot documentSnapshot : documentSnapshots) {
      CookieObject cookie = documentSnapshot.toObject(CookieObject.class);
      System.out.println(cookie);
    }
    System.out.println("共计：" + querySnapshot.get().size());


    System.out.println("************************************");
    //Iterable<DocumentReference> documents = users.listDocuments();
    //int i = 0;
    //for (DocumentReference documentReference : documents) {
    //  i ++;
    //  CookieObject cookie = documentReference.get().get().toObject(CookieObject.class);
    //  System.out.println(cookie);
    //}
    //System.out.println("共计：" + i);

    //for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
    //  CookieObject cookie = document.toObject(CookieObject.class);
    //  System.out.println(cookie);
    //}
  }
}
