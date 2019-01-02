package one.jamaa.appjamaa.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;

import javax.annotation.Nullable;

import one.jamaa.appjamaa.information.Projects;

public class FirestoreHelper {

    private static final String TAG = "FirestoreHelper";

    private FirestoreRecyclerOptions<Projects> options;
    private DocumentReference documentReference;
    private String userID;
    private ListenerRegistration listenerRegistration;

    public FirestoreHelper(){
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firebaseFirestore.collection("Projects");
        documentReference = collectionReference.document();
        Query query = collectionReference.orderBy("timestamp", Query.Direction.ASCENDING);
        options = new FirestoreRecyclerOptions.Builder<Projects>()
                .setQuery(query, Projects.class)
                .build();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null){
            userID = mAuth.getCurrentUser().getUid();
        }
    }

    public void addProject(Projects project){
        Log.d(TAG, "addProject: ");
        documentReference.set(project).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "onSuccess: ");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }
        });
    }

    public void onStart(){
        Log.d(TAG, "onStart: ");
        listenerRegistration = documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d(TAG, "onEvent: " + e.getMessage());
                    return;
                }
                if (documentSnapshot.exists()){
                    Log.d(TAG, "onEvent: ");
                }
            }
        });
    }

    public void onStop(){
        listenerRegistration.remove();
    }

    public FirestoreRecyclerOptions<Projects> getOptions() {
        return options;
    }
}
