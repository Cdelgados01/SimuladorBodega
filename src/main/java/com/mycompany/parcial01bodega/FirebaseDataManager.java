
package com.mycompany.parcial01bodega;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;



public class FirebaseDataManager {

    private Firestore db;

    public FirebaseDataManager(Firestore firestore) {
        this.db = firestore;
    }

    public void agregarDatos(String coleccion, String documento, Map<String, Object> datos) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(datos);
            result.get();
            System.out.println("Datos agregados exitosamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al agregar datos: " + e.getMessage());
        }
    }

    public void actualizarDatos(String coleccion, String documento, Object datos) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(datos);
            result.get();
            System.out.println("Datos actualizados exitosamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al actualizar datos: " + e.getMessage());
        }
    }

    public void eliminarDatos(String coleccion, String documento) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete();
            result.get();
            System.out.println("Datos eliminados exitosamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al eliminar datos: " + e.getMessage());
        }
    }
    
    public Map<String, Object> obtenerDatos(String coleccion, String documento) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            DocumentSnapshot document = docRef.get().get();

            if (document.exists()) {
                return document.getData();
            } else {
                System.out.println("El documento no existe.");
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al obtener datos: " + e.getMessage());
            return null;
        }
    }


}

