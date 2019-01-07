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
import one.jamaa.appjamaa.information.Users;

public class FirestoreHelper {

    private static final String TAG = "FirestoreHelper";

    private FirestoreRecyclerOptions<Projects> options;
    private DocumentReference documentReference;
    private ListenerRegistration listenerRegistration;

    public FirestoreHelper(String information){
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firebaseFirestore.collection(information);
        documentReference = collectionReference.document(userID);
        Query query = collectionReference.orderBy("duration", Query.Direction.ASCENDING);
        options = new FirestoreRecyclerOptions.Builder<Projects>()
                .setQuery(query, Projects.class)
                .build();
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

    public void addUser(Users user){
        Log.d(TAG, "addUser: ");
        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
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
