package one.jamaa.appjamaa.main.contract.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import java.text.DateFormat;
import java.util.Calendar;
import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;


public class NewContractFragment_2 extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final String TAG = "NewContractFragment_2";

    private EditText projectBeginDate, projectEndDate, projectDuration;
    private ButtonPressed buttonPressed;
    public enum ButtonPressed{
        NO_BUTTON_PRESSED, BEGIN_DATE, END_DATE, DURATION
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_contract_2, null);
        Log.d(TAG, "onCreateView: ");
        findViewById(view);
        projectBeginDate.setOnClickListener(this);
        projectEndDate.setOnClickListener(this);
        projectDuration.setOnClickListener(this);
        return view;
    }

    // TODO getSupportFragmentManager vs getFragmentManager?
    @Override
    public void onClick(View view) {
        buttonPressed = ButtonPressed.NO_BUTTON_PRESSED;
        switch (view.getId()){
            case R.id.project_begin_date:
                DialogFragment beginDate = new CalendarFragment();
                beginDate.setTargetFragment(NewContractFragment_2.this, 0);
                beginDate.show(getActivity().getSupportFragmentManager(), "Begin Date");
                buttonPressed = ButtonPressed.BEGIN_DATE;
                Log.d(TAG, "onClick: Begin Date");
                break;
            case R.id.project_end_date:
                DialogFragment endDate = new CalendarFragment();
                endDate.setTargetFragment(NewContractFragment_2.this, 0);
                endDate.show(getActivity().getSupportFragmentManager(), "End Date");
                buttonPressed = ButtonPressed.END_DATE;
                Log.d(TAG, "onClick: End Date");
                break;
            case R.id.project_duration:
                DialogFragment duration = new CalendarFragment();
                duration.setTargetFragment(NewContractFragment_2.this, 0);
                duration.show(getActivity().getSupportFragmentManager(), "Duration");
                buttonPressed = ButtonPressed.DURATION;
                Log.d(TAG, "onClick: Duration");
                break;
        }
    }

    public void setProject(Projects project){
        project.setBegin(projectBeginDate.getText().toString());
        project.setEnd(projectEndDate.getText().toString());
        project.setDuration(projectDuration.getText().toString());
    }

    private void findViewById(View view) {
        projectBeginDate = view.findViewById(R.id.project_begin_date);
        projectEndDate = view.findViewById(R.id.project_end_date);
        projectDuration = view.findViewById(R.id.project_duration);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, i);
        calendar.set(Calendar.MONTH, i1);
        calendar.set(Calendar.DAY_OF_MONTH, i2);
        String pickedDate = DateFormat.getDateInstance().format(calendar.getTime());
        switch (buttonPressed){
            case BEGIN_DATE:
                projectBeginDate.setText(pickedDate);
                break;
            case END_DATE:
                projectEndDate.setText(pickedDate);
                break;
            case DURATION:
                projectDuration.setText(pickedDate);
                break;
        }
        Log.d(TAG, "onDateSet: " + pickedDate);    }
}