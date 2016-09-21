package com.example.huawei.formuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity implements UserForm.OnUserSavedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.form_user,
                UserForm.newInstance()).commit();



    }

    @Override
    public void onUserSaved(User user) {

        UserDetails fragment = UserDetails.newInstance(user);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.form_user, fragment)
                .addToBackStack(null)
                .commit();

    }
}
