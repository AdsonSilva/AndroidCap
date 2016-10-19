package com.example.adson_silva.atividadeaula8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView buildType, flavor, appId;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildType = (TextView) findViewById(R.id.BuildType);
        flavor = (TextView) findViewById(R.id.Flavor);
        appId = (TextView) findViewById(R.id.appId);


        buildType.setText(BuildConfig.BUILD_TYPE);
        flavor.setText(BuildConfig.VERSION_NAME);
        appId.setText(BuildConfig.APPLICATION_ID);
    }
}
