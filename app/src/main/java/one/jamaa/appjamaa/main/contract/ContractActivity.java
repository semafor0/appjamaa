package one.jamaa.appjamaa.main.contract;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment;
import one.jamaa.appjamaa.registration.LoginActivity;
import one.jamaa.appjamaa.utils.BottomNavigationViewHelper;
import one.jamaa.appjamaa.utils.FirestoreHelper;

public class ContractActivity extends AppCompatActivity implements NewContractFragment.NewContractListener {

    private static final String TAG = "ContractActivity";
    private static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + FirebaseAuth.getInstance().getCurrentUser());
        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_contract);
        setupBottomNavigationView();
        Button createContract = findViewById(R.id.button_create_contract);
        createContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        NewContractFragment fragment = new NewContractFragment();
        fragment.show(getSupportFragmentManager(), "testtesttest");
    }

    private void setupBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ContractActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public void applyTexts(Projects project) {
        FirestoreHelper firestoreHelper = new FirestoreHelper();
        firestoreHelper.addProject(project);
    }
}