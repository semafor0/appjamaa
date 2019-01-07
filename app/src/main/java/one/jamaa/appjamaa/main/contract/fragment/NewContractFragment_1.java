package one.jamaa.appjamaa.main.contract.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;
import one.jamaa.appjamaa.utils.FirestoreHelper;

public class NewContractFragment_1 extends Fragment {

    private EditText title;
    private EditText user;
    private EditText trust;
    private EditText fundingGoal;
    private EditText profit;
    private EditText duration;
    private NewContractListener listener;
    private FirestoreHelper firestoreHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_contract_1, null);
        findViewById(view);
        firestoreHelper = new FirestoreHelper(getResources().getString(R.string.projects));
        ///listener.applyTexts(createProject());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (NewContractListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        firestoreHelper.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        firestoreHelper.onStop();
    }

    private Projects createProject(){
        return new Projects(
        title.getText().toString(),
        user.getText().toString(),
        trust.getText().toString(),
        fundingGoal.getText().toString(),
        profit.getText().toString(),
        duration.getText().toString());
    }

    public interface NewContractListener{
        void applyTexts(Projects project);
    }

    private void findViewById(View view) {
        title = view.findViewById(R.id.name_project);
        user = view.findViewById(R.id.dummy_user);
        trust = view.findViewById(R.id.dummy_trust);
        fundingGoal = view.findViewById(R.id.funding_goal);
        profit = view.findViewById(R.id.expected_profit);
        duration = view.findViewById(R.id.duration);
    }


}
