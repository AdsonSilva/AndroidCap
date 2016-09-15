package com.example.huawei.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textGorjeta;
    private SeekBar seekGorjeta;
    private RadioGroup numPessoas;
    private RadioButton maisPessoas;
    private TextView numMaisPessoas;
    private EditText valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekGorjeta = (SeekBar) findViewById(R.id.seekPercent);
        textGorjeta = (TextView) findViewById(R.id.seekText);
        maisPessoas = (RadioButton) findViewById(R.id.btnMore);
        numPessoas = (RadioGroup) findViewById(R.id.radioGroup);
        numMaisPessoas = (EditText) findViewById(R.id.edtPersons);
        valor = (EditText) findViewById(R.id.edtValue);
        RelativeLayout green = (RelativeLayout) findViewById(R.id.layoutGreen);

        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        maisPessoas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                numPessoas.setVisibility(View.GONE);
                numMaisPessoas.setVisibility(View.VISIBLE);
            }
        });

    }

    private void calcula(){

        int porcentagem = seekGorjeta.getProgress();
        int pessoas = getPessoas();
        double conta = Double.parseDouble(valor.getText().toString());
        double gorjeta = (conta*porcentagem)/100;

        double total = conta + gorjeta;



    }

    private int getPessoas(){

        int pessoas = 0;

        if(numPessoas.getCheckedRadioButtonId() == R.id.btnMore){
            return Integer.parseInt(numMaisPessoas.getText().toString());

        }else{

            switch (numPessoas.getCheckedRadioButtonId()){

                case R.id.person1:
                    pessoas = 1;
                    break;

                case R.id.person2:
                    pessoas = 2;
                    break;

                case R.id.person3:
                    pessoas = 3;
                    break;

                case R.id.person4:
                    pessoas = 4;
                    break;

                case R.id.person5:
                    pessoas = 5;
                    break;
            }

        }
        return pessoas;

    }
}