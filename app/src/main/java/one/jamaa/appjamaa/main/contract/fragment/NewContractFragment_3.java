package one.jamaa.appjamaa.main.contract.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.HashMap;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;
import one.jamaa.appjamaa.utils.FirestoreHelper;

public class NewContractFragment_3 extends Fragment {

    private static final String TAG = "NewContractFragment_3";

    private EditText projectFundingGoal, projectExpectedProfitHigh, projectExpectedProfit;
    private TextView investor, mudarib;
    private SeekBar shareSeekBar;
    private int investorPercentage, mudaribPercentage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_contract_3, null);
        Log.d(TAG, "onCreateView: ");
        findViewById(view);
        shareSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                investor.setText(getResources().getString(R.string.percentage, i, "%"));
                mudarib.setText(getResources().getString(R.string.percentage, 100-i, "%"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                investorPercentage = seekBar.getProgress();
                mudaribPercentage = 100-investorPercentage;
            }
        });
        return view;
    }

    public void setProject(Projects project){
        project.setFundingGoal(projectFundingGoal.getText().toString());
        project.setProfitHigh(projectExpectedProfitHigh.getText().toString());
        project.setProfit(projectExpectedProfit.getText().toString());
        project.setInvestorShare(String.valueOf(investorPercentage));
        project.setMudaribShare(String.valueOf(mudaribPercentage));
    }


    private void findViewById(View view) {
        projectFundingGoal = view.findViewById(R.id.project_funding_goal);
        projectExpectedProfitHigh = view.findViewById(R.id.project_expected_profit_high);
        projectExpectedProfit = view.findViewById(R.id.project_expected_profit);
        investor = view.findViewById(R.id.investor_share);
        mudarib = view.findViewById(R.id.mudarib_share);
        shareSeekBar = view.findViewById(R.id.project_seek_bar_profit_share_percentage);
    }


}