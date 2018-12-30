package one.jamaa.appjamaa.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import one.jamaa.appjamaa.R;

public class ResetActivity extends AppCompatActivity {

    private static final String TAG = "ResetActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_reset);
    }
}
