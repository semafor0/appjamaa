package one.jamaa.appjamaa.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.registration.LoginActivity;
import one.jamaa.appjamaa.utils.PreferencesManager;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "WelcomeActivity";

    private ViewPager viewPager;
    private int[] layoutIds;
    private PreferencesManager prefManager;
    private Button buttonSkip, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        prefManager = new PreferencesManager(this);
        if(!prefManager.isFirstTimeLaunch()){
            launchStartScreen();
        }
        setContentView(R.layout.activity_welcome);
        viewPager = findViewById(R.id.welcome_viewpager);
        buttonSkip = findViewById(R.id.button_skip);
        buttonNext = findViewById(R.id.button_next);

        buttonSkip.setOnClickListener(this);
        buttonNext.setOnClickListener(this);


        layoutIds = new int[]{
                R.layout.welcome_1,
                R.layout.welcome_2,
                R.layout.welcome_3,
                R.layout.welcome_4
        };

        MyViewPagerAdapter pagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void launchStartScreen() {
        Log.d(TAG, "launchStartScreen: ");
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "onPageSelected: " + position);
        if(position == layoutIds.length - 1){
            buttonNext.setText(getString(R.string.start));
            buttonSkip.setVisibility(View.GONE);
        } else{
            buttonNext.setText(getString(R.string.next));
            buttonSkip.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_skip:
                launchStartScreen();
                break;
            case R.id.button_next:
                int current = viewPager.getCurrentItem() + 1;
                if (current < layoutIds.length){
                    viewPager.setCurrentItem(current);
                } else{
                    launchStartScreen();
                }
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    class MyViewPagerAdapter extends PagerAdapter {

        LayoutInflater inflater;

        @Override
        public int getCount() {
            return layoutIds.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(layoutIds[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
