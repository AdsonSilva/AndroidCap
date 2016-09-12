package com.example.huawei.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}