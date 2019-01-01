package one.jamaa.appjamaa.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import one.jamaa.appjamaa.R;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "RegistrationActivity";

    private EditText registerEmail, createPassword, confirmPassword;
    private Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_registration);
        findViewById();
        registerButton.setOnClickListener(view -> {
            registerUser();
        });
    }

    private void registerUser() {
        String email = registerEmail.getText().toString().trim();
        String password = createPassword.getText().toString().trim();
        String verfiyPassword = confirmPassword.getText().toString().trim();

        if(email.isEmpty()){
            registerEmail.setError("Email is required!");
            registerEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            registerEmail.setError("Please enter a valid email!");
            registerEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            createPassword.setError("Password is required");
            createPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            createPassword.setError("Minimum length of password should be 6!");
            createPassword.requestFocus();
            return;
        }
        if(!verfiyPassword.equals(password)){
            confirmPassword.setError("Password are not equal!");
            confirmPassword.requestFocus();
            return;
        }
    }

    private void findViewById() {
        registerEmail = findViewById(R.id.register_email);
        createPassword = findViewById(R.id.create_password);
        confirmPassword = findViewById(R.id.confirm_password);
        registerButton = findViewById(R.id.button_sign_up);
    }
}
