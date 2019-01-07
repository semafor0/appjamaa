package one.jamaa.appjamaa.tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.adapter.ProjectsAdapter;
import one.jamaa.appjamaa.utils.FirestoreHelper;

public class TestActivity extends AppCompatActivity {

    private ProjectsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        FirestoreHelper firestoreHelper = new FirestoreHelper(getResources().getString(R.string.projects));
        adapter = new ProjectsAdapter(firestoreHelper.getOptions());
        RecyclerView recyclerView = findViewById(R.id.recycler_view_test);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
