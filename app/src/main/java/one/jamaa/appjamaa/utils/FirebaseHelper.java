package one.jamaa.appjamaa.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import one.jamaa.appjamaa.registration.LoginActivity;

public class FirebaseHelper {

    private static final String TAG = "FirebaseHelper";

    private final FirebaseAuth mAuth;
    private final Context context;
    private final FirebaseUser user;

    public FirebaseHelper(Context context){
        mAuth = FirebaseAuth.getInstance();
        this.context = context;
        user = mAuth.getCurrentUser();
    }

    public void register(String email, String password){
        Log.d(TAG, "register: ");
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
           if (task.isSuccessful()){
               Log.d(TAG, "register: success");
               sendEmailVerification();
           } else{
               Log.d(TAG, "register: failed");
           }
        });
    }

    private void sendEmailVerification() {
        Log.d(TAG, "sendEmailVerification: ");
        if (user != null){
            user.sendEmailVerification().addOnCompleteListener(task -> {
               if(task.isSuccessful()){
                   Toast.makeText(context, "Verify your email please", Toast.LENGTH_LONG).show();
                   mAuth.signOut();
                   Intent intent = new Intent(context, LoginActivity.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   context.startActivity(intent);
               } else{
                   Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
               }
            });
        }
    }

    public void signOut(){
        Log.d(TAG, "signOut: ");
        mAuth.signOut();
    }

}