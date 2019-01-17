package one.jamaa.appjamaa.main.contract.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Projects;
import one.jamaa.appjamaa.main.contract.ProjectViewModel;

public class NewContractFragment_4 extends Fragment {

    private static final String TAG = "NewContractFragment_4";

    private TextView a, b ,c, d, e, f, g, h, i, j, k;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_contract_4, null);
        Log.d(TAG, "onCreateView: ");
        findViewById(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProjectViewModel viewModel = ViewModelProviders.of(getActivity()).get(ProjectViewModel.class);
        viewModel.getProject().observe(getViewLifecycleOwner(), new Observer<Projects>() {
            @Override
            public void onChanged(@Nullable Projects projects) {
                a.setText(projects.getDuration());
                b.setText(projects.getProfit());
                c.setText(projects.getProfitHigh());
                d.setText(projects.getFundingGoal());
                e.setText(projects.getTitle());
                f.setText(projects.getBegin());
                g.setText(projects.getEnd());
                h.setText(projects.getInvestorShare());
                i.setText(projects.getMudaribShare());
                j.setText(projects.getTrust());
                k.setText(projects.getLocation());
            }
        });
    }


    private void findViewById(View view) {
        a = view.findViewById(R.id.title_contract_summary);
        b = view.findViewById(R.id.description_contract_summary);
        c = view.findViewById(R.id.label_user_contract_summary);
        d = view.findViewById(R.id.text_user_contract_summary);
        e = view.findViewById(R.id.label_name_contract_summary);
        f = view.findViewById(R.id.text_name_contract_summary);
        g = view.findViewById(R.id.label_begin_contract_summary);
        h = view.findViewById(R.id.text_begin_contract_summary);
        i = view.findViewById(R.id.label_end_contract_summary);
        j = view.findViewById(R.id.text_end_contract_summary);
        k = view.findViewById(R.id.label_duration_contract_summary);
    }

}
