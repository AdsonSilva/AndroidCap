package com.example.huawei.tipcalculator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar gorjeta = (SeekBar) findViewById(R.id.seekPercent);
        final TextView textGorjeta = (TextView) findViewById(R.id.seekText);
        final RadioButton btnMore = (RadioButton) findViewById(R.id.btnMore);
        final RadioGroup groupPersons = (RadioGroup) findViewById(R.id.radioGroup);

        gorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                textGorjeta.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textGorjeta.setText(progress + "%");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textGorjeta.setText(progress + "%");
            }

        });

       







    }

    public void more(View v){

    }
}