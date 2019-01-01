package one.jamaa.appjamaa.utils;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseHelper {

    private static final String TAG = "FirebaseHelper";

    private Context context;
    private  FirebaseAuth mAuth;

    public FirebaseHelper(Context context) {
        mAuth = FirebaseAuth.getInstance();
    }

}