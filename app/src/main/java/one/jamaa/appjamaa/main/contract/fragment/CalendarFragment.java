package one.jamaa.appjamaa.main.contract.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import java.util.Calendar;

public class CalendarFragment extends DialogFragment {

    private static final String TAG = "CalendarFragment";

    private Activity mActivity;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Log.d(TAG, "onCreateDialog: " + year + "/" + month + "/" + day);
        return new DatePickerDialog(mActivity, (DatePickerDialog.OnDateSetListener) getTargetFragment(),year, month, day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        Log.d(TAG, "onAttach: " + mActivity);
        Log.d(TAG, "onAttach: " + getActivity());
    }
}
