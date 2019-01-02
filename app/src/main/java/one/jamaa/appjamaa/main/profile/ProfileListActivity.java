package one.jamaa.appjamaa.main.profile;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.main.profile.fragment.ProjectsFragment;
import one.jamaa.appjamaa.main.profile.fragment.UsersFragment;
import one.jamaa.appjamaa.registration.LoginActivity;
import one.jamaa.appjamaa.utils.BottomNavigationViewHelper;
import one.jamaa.appjamaa.utils.SectionsPageAdapter;

public class ProfileListActivity extends AppCompatActivity {

    private static final String TAG = "ProfileListActivity";
    private static final int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + FirebaseAuth.getInstance().getCurrentUser());
        if(FirebaseAuth.getInstance().getCurrentUser().getUid() == null){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_profile_list);
        setupBottomNavigationView();
        setupViewPager();
    }

    private void setupBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileListActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void setupViewPager() {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragments(new ProjectsFragment(), "Projects");
        adapter.addFragments(new UsersFragment(), "Users");
        ViewPager pager = findViewById(R.id.pager_home);
        pager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs_profile_list);
        tabLayout.setupWithViewPager(pager);
    }
}
