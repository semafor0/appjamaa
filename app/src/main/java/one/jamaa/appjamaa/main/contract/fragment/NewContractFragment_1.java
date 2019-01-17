package one.jamaa.appjamaa.main.contract.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.HashMap;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;
import one.jamaa.appjamaa.main.contract.ProjectViewModel;

public class NewContractFragment_1 extends Fragment {

    private static final String TAG = "NewContractFragment_1";

    private EditText projectName, projectLocation, projectTrust;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_contract_1, null);
        Log.d(TAG, "onCreateView: ");
        findViewById(view);
        return view;
    }

    public void setProject(Projects project){
        project.setTitle(projectName.getText().toString());
        project.setLocation(projectLocation.getText().toString());
        project.setTrust(projectTrust.getText().toString());
    }


    private void findViewById(View view) {
        projectName = view.findViewById(R.id.project_name);
        projectLocation = view.findViewById(R.id.project_location);
        projectTrust = view.findViewById(R.id.project_trust);
    }
}
