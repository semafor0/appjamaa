package one.jamaa.appjamaa.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.main.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private TextView forgotPassword, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        Log.d(TAG,"user: " + user);
        checkUser();
        findViewById();
        setOnClick();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_sign_in:
                loginUser();
                break;
            case R.id.forgot_password:
                Intent intentReset = new Intent(LoginActivity.this, ResetActivity.class);
                intentReset.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentReset);
                finish();
                break;
            case R.id.register:
                Intent intentRegister = new Intent(LoginActivity.this, RegistrationActivity.class);
                intentRegister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentRegister);
                finish();
                break;
        }
    }

    private void loginUser() {
        Log.d(TAG, "loginUser: ");
        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

        if(email.isEmpty()){
            loginEmail.setError("Email is required");
            loginEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginEmail.setError("Please enter a valid email");
            loginEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            loginPassword.setError("Password is required");
            loginPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            loginPassword.setError("Minimum length of password should be 6");
            loginPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                task -> {
                    if(task.isSuccessful()){
                        checkEmailVerification();
                    } else{
                        // TODO Warning?
                        Throwable exceptionCause = task.getException().getCause();
                        String exceptionMessage = task.getException().getMessage();
                        Log.i(TAG, String.valueOf(exceptionCause));
                        if(exceptionCause instanceof FirebaseAuthInvalidUserException){
                            Log.i(TAG, exceptionMessage + " e1");
                            loginEmail.setError(exceptionMessage);
                            loginEmail.requestFocus();
                        }else if (exceptionCause instanceof FirebaseAuthInvalidCredentialsException) {
                            Log.i(TAG, exceptionMessage + " e2");
                            loginPassword.setError(exceptionMessage);
                            loginPassword.requestFocus();
                        } else{
                            Toast.makeText(this, exceptionMessage, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void checkEmailVerification() {
        if (user != null) {
            Boolean verification = user.isEmailVerified();
            if (verification) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Verify your email please!", Toast.LENGTH_LONG).show();
                mAuth.signOut();
            }
        }else{
            Toast.makeText(this, "Email doesn't exist. Please Register!", Toast.LENGTH_LONG).show();
        }
    }

    private void checkUser() {
        if(user != null){
            Intent intentLoggedIn = new Intent(LoginActivity.this, HomeActivity.class);
            intentLoggedIn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentLoggedIn);
            finish();
        }
    }

    private void findViewById() {
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.button_sign_in);
        forgotPassword = findViewById(R.id.forgot_password);
        register = findViewById(R.id.register);
    }

    private void setOnClick() {
        loginButton.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
        register.setOnClickListener(this);
    }
}
