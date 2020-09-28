package com.wblei.playfirebaseandroid;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

  private Button insertBtn;
  private Button updateBtn;
  private final String TAG = "MainActivity";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    insertBtn = findViewById(R.id.insertData);
    updateBtn = findViewById(R.id.updateData);

    final FirebaseFirestore db = FirebaseFirestore.getInstance();


    insertBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        User user = new User("lwb" + System.currentTimeMillis(), "123456");
        db.collection("user").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
          @Override public void onSuccess(DocumentReference documentReference) {
            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
          }
        }).addOnFailureListener(new OnFailureListener() {
          @Override public void onFailure(@NonNull Exception e) {
            Log.w(TAG, "Error adding document", e);
          }
        });
      }
    });

    updateBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        DocumentReference docRef = db.collection("user").document("ixMPoNSVHg80qpXtYv6j1");
        if (docRef != null) {
          User user = new User("lwb" + System.currentTimeMillis(), "111111");
          docRef.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override public void onSuccess(Void aVoid) {
              Log.d(TAG, "DocumentSnapshot successfully written!");
            }
          })
          .addOnFailureListener(new OnFailureListener() {
            @Override public void onFailure(@NonNull Exception e) {
              Log.w(TAG, "Error writing document", e);
            }
          });
        } else {
          User user = new User("lwb" + System.currentTimeMillis(), "123456");
          db.collection("user").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override public void onSuccess(DocumentReference documentReference) {
              Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
            }
          }).addOnFailureListener(new OnFailureListener() {
            @Override public void onFailure(@NonNull Exception e) {
              Log.w(TAG, "Error adding document", e);
            }
          });
        }
      }
    });
  }
}