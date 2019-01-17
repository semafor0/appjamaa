package one.jamaa.appjamaa.main.contract;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_1;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_2;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_3;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_4;
import one.jamaa.appjamaa.utils.FirestoreHelper;
import one.jamaa.appjamaa.utils.NonSwipeableViewPager;
import one.jamaa.appjamaa.utils.SectionsPageAdapter;

public class NewContractActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "NewContractActivity";

    private NonSwipeableViewPager pager;
    private SectionsPageAdapter sectionsPageAdapter;
    private Button buttonNext;
    private NewContractFragment_1 newContractFragment_1;
    private NewContractFragment_2 newContractFragment_2;
    private NewContractFragment_3 newContractFragment_3;
    private NewContractFragment_4 newContractFragment_4;
    private Toolbar toolBar;
    private Projects project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_new_contract);
        toolBar = findViewById(R.id.tool_bar);
        pager = findViewById(R.id.view_pager);
        buttonNext = findViewById(R.id.button_contract_next);
        buttonNext.setOnClickListener(this);
        newContractFragment_1 = new NewContractFragment_1();
        newContractFragment_2 = new NewContractFragment_2();
        newContractFragment_3 = new NewContractFragment_3();
        newContractFragment_4 = new NewContractFragment_4();
        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        setupToolbar();
        setupViewPager(sectionsPageAdapter);
        project = new Projects();
    }

    private void setupToolbar(){
        setSupportActionBar(toolBar);
    }

    private void setupViewPager(SectionsPageAdapter adapter) {
        adapter.addFragments(newContractFragment_1,
                getResources().getString(R.string.new_contract_fragment_title_page_1));
        adapter.addFragments(newContractFragment_2,
                getResources().getString(R.string.new_contract_fragment_title_page_2));
        adapter.addFragments(newContractFragment_3,
                getResources().getString(R.string.new_contract_fragment_title_page_3));
        adapter.addFragments(newContractFragment_4,
                getResources().getString(R.string.new_contract_fragment_title_page_4));
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                toolBar.setTitle(adapter.getPageTitle(i));
                if (i == sectionsPageAdapter.getCount() - 1){
                    buttonNext.setText(getResources().getString(R.string.create_contract));
                } else {
                    buttonNext.setText(getResources().getString(R.string.next_step));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }
    

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_contract_next:
                int current = pager.getCurrentItem() + 1;
                if (current < sectionsPageAdapter.getCount()){
                    pager.setCurrentItem(current);
                    switch(current){
                        case 1:
                            newContractFragment_1.setProject(project);
                            break;
                        case 2:
                            newContractFragment_2.setProject(project);
                            break;
                        case 3:
                            newContractFragment_3.setProject(project);
                            ProjectViewModel viewModel = ViewModelProviders.of(this).get(ProjectViewModel.class);
                            viewModel.setProject(project);
                            break;
                    }
                } else {
                    //TODO testen
                    FirestoreHelper firestoreHelper = new FirestoreHelper(getResources().getString(R.string.projects));
                    firestoreHelper.addProject(project);
                    startActivity(new Intent(NewContractActivity.this, ContractActivity.class));
                    finish();
                }
                break;
        }
    }

}
