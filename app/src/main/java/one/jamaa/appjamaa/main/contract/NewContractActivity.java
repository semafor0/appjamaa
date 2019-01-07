package one.jamaa.appjamaa.main.contract;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_1;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_2;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_3;
import one.jamaa.appjamaa.main.contract.fragment.NewContractFragment_4;
import one.jamaa.appjamaa.utils.SectionsPageAdapter;

public class NewContractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contract);
    }

    private void setupViewPager() {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragments(new NewContractFragment_1(), "Blablabla1");
        adapter.addFragments(new NewContractFragment_2(), "Blablabla2");
        adapter.addFragments(new NewContractFragment_3(), "Blablabla3");
        adapter.addFragments(new NewContractFragment_4(), "Blablabla4");
        ViewPager pager = findViewById(R.id.view_pager);
        pager.setAdapter(adapter);

    }
}
