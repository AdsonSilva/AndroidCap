package com.example.huawei.userFormApp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.huawei.exemploaula4.R;

/**
 * Created by huawei on 08/09/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.form_fragment, UserFormFragment.newInstance()).commit();
    }
}
