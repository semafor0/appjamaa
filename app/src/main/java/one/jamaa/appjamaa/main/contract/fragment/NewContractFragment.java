package one.jamaa.appjamaa.main.contract.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;
import one.jamaa.appjamaa.utils.FirestoreHelper;

public class NewContractFragment extends AppCompatDialogFragment {

    private EditText title;
    private EditText user;
    private EditText trust;
    private EditText fundingGoal;
    private EditText profit;
    private EditText duration;
    private NewContractListener listener;
    private FirestoreHelper firestoreHelper;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog_new_contract, null);
        findViewById(view);
        firestoreHelper = new FirestoreHelper();
        builder.setView(view)
                .setTitle("New Contract")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).setPositiveButton("Create Contract", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.applyTexts(createProject());
            }
        });
        return builder.create();
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
        user = view.findViewById(R.id.location_project);
        trust = view.findViewById(R.id.begin_date);
        fundingGoal = view.findViewById(R.id.funding_goal);
        profit = view.findViewById(R.id.expected_profit);
        duration = view.findViewById(R.id.duration);
    }


}
