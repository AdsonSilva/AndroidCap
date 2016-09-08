package com.example.huawei.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, String.format("%s.%s", getClassName(), "onCreate()"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, String.format("%s.%s", getClassName(), "onStart()"));
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, String.format("%s.%s", getClassName(), "onResume()"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, String.format("%s.%s", getClassName(), "onPause()"));
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, String.format("%s.%s", getClassName(), "onStop()"));
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, String.format("%s.%s", getClassName(), "onRestart()"));
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, String.format("%s.%s", getClassName(), "onDestroy()"));
        super.onDestroy();
    }

    public String getClassName(){
        String className = getClass().getName();
        return (className.substring(className.lastIndexOf(".")+1));
    }

}
