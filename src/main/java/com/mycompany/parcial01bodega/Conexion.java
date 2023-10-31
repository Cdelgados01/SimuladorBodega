
package com.mycompany.parcial01bodega;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;



public class Conexion {
    
    public static Firestore db;
    
    public static void conectarFirebase(){
         try {
            FileInputStream sa = new FileInputStream("clavefirebasejava.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(sa))
            .build();

            FirebaseApp.initializeApp(options);
             
            db = FirestoreClient.getFirestore();
            System.out.println("La conexión se realizo exitosamente...");
        } catch (IOException e) {
            System.err. println("Error: " + e.getMessage());
        }
    }
    
}