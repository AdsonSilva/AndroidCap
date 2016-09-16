package com.example.huawei.tipcalculator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekGorjeta;
    private RadioGroup numPessoas;
    private RadioButton maisPessoas;
    private TextView numMaisPessoas;
    private EditText valor;
    private Button btnCalular;
    private Button btnReset;
    private RelativeLayout green;
    private TextView textTotal;
    private TextView textGorjeta;
    private TextView textPorPessoa;

    private RelativeLayout layoutGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            TextView gorjetaText = (TextView) findViewById(R.id.seekText);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                gorjetaText.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                gorjetaText.setText(progress + "%");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                gorjetaText.setText(progress + "%");
            }

        });

        maisPessoas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                numPessoas.setVisibility(View.GONE);
                numMaisPessoas.setVisibility(View.VISIBLE);
            }
        });

        btnCalular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcula();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    private void init(){
        this.seekGorjeta = (SeekBar) findViewById(R.id.seekPercent);
        this.maisPessoas = (RadioButton) findViewById(R.id.btnMore);
        this.numPessoas = (RadioGroup) findViewById(R.id.radioGroup);
        this.numMaisPessoas = (EditText) findViewById(R.id.edtPersons);
        this.valor = (EditText) findViewById(R.id.edtValue);
        this.green = (RelativeLayout) findViewById(R.id.layoutGreen);
        this.btnCalular = (Button) findViewById(R.id.calculateButton);
        this.btnReset = (Button) findViewById(R.id.resetButton);
        this.textTotal = (TextView) findViewById(R.id.valorTotal);
        this.textGorjeta = (TextView) findViewById(R.id.valorGorjeta);
        this.textPorPessoa = (TextView) findViewById(R.id.totalPessoa);

        this.layoutGreen = (RelativeLayout) findViewById(R.id.layoutGreen);

    }

    private void calcula(){

        int porcentagem = seekGorjeta.getProgress();
        int pessoas = getPessoas();
        double conta = Double.parseDouble(valor.getText().toString());
        double gorjeta = (conta*porcentagem)/100;

        double total = conta + gorjeta;

        double porPessoa = total/pessoas;

        textTotal.setText("R$: " + String.format("%.2f", total));
        textGorjeta.setText("R$: " +String.format("%.2f", gorjeta));
        textPorPessoa.setText("R$: " + String.format("%.2f", porPessoa));

    }

    public void reset(){
        textTotal.setText("");
        textGorjeta.setText("");
        textPorPessoa.setText("");
        seekGorjeta.setProgress(10);
        valor.clearComposingText();
        numPessoas.check(R.id.person1);
        numPessoas.setVisibility(View.VISIBLE);
        numMaisPessoas.setVisibility(View.GONE);
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