package one.jamaa.appjamaa.main.profile.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.adapter.ProjectsAdapter;
import one.jamaa.appjamaa.utils.FirestoreHelper;

public class ProjectsFragment extends Fragment {

    private static final String TAG = "ProjectsFragment";

    private ProjectsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projects, container, false);
        FirestoreHelper firestoreHelper = new FirestoreHelper(getResources().getString(R.string.projects));
        adapter = new ProjectsAdapter(firestoreHelper.getProjectsOptions());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_projects);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);
        adapter.setOnItemClickListener(new ProjectsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot snapshot, int position) {
                Log.d(TAG, "onItemClick: Position: " + position);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        adapter.startListening();
    }
}
