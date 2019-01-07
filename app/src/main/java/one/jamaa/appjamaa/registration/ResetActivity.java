package one.jamaa.appjamaa.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.utils.Utils;

public class ResetActivity extends AppCompatActivity {

    private static final String TAG = "ResetActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_reset);
        Utils.hideKeyboard(this);
        EditText emailReset = findViewById(R.id.edit_text_email_reset);
        Button reset = findViewById(R.id.button_submit_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailReset.getText().toString().trim();
                if (email.isEmpty()) {
                    emailReset.setError("Email is required");
                    emailReset.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailReset.setError("Please enter a valid email");
                    emailReset.requestFocus();
                    return;
                }
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(ResetActivity.this, "Please check your emails", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ResetActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else {
                        emailReset.setError(task.getException().getMessage());
                        emailReset.requestFocus();
                    }
                });

            }
        });
    }
}