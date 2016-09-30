package com.example.huawei.mapproject;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.location.LocationServices;

public class LocalizacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


    }
}
