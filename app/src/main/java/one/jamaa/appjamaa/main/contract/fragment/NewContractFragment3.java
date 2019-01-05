package one.jamaa.appjamaa.main.contract.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import one.jamaa.appjamaa.R;

public class NewContractFragment3 extends AppCompatActivity {


    private TextView textView;
    private TextView textView1;
    private SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dialog_new_contract_3);



        seekBar = (SeekBar) findViewById(R.id.seek_bar_profit_share_percentage);

        final TextView seekBarValue = (TextView)findViewById(R.id.investor_share);

        final TextView seekBarValue1 = (TextView)findViewById(R.id.mudarib_share);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                seekBarValue.setText(String.valueOf(progress + "%"));

                seekBarValue1.setText(String.valueOf(100 - progress + "%" ));
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
