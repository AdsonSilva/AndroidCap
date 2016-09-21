package com.example.huawei.formuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity implements UserForm.OnUserSavedListener{

    private static final String FRAGMENT_USER_EDIT = "fragment_form";
    private static final String FRAGMENT_USER_DETAIL = "fragment_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.resolution,
                UserForm.newInstance()).commit();

    }

    @Override
    public void onUserSaved(User user) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.form_user, fragment)
                .addToBackStack(null)
                .commit();

    }
}
