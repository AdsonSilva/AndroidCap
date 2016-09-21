package com.example.huawei.formuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity implements UserForm.OnUserSavedListener{

    private static final String TAG_DETAILS = "user_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.form_user,
                UserForm.newInstance()).commit();

        if(isTablet()){
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_user,
                    UserDetails.newInstance(), TAG_DETAILS).commit();
        }



    }

    @Override
    public void onUserSaved(User user) {

        if(isTablet()){
            UserForm.OnUserSavedListener callback =
                    (UserForm.OnUserSavedListener)getSupportFragmentManager()
                    .findFragmentByTag(TAG_DETAILS);

            callback.onUserSaved(user);

        }else {

            UserDetails fragment = UserDetails.newInstance(user);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.form_user, fragment)
                    .addToBackStack(null)
                    .commit();
        }

    }

    private boolean isTablet(){
        return getResources().getBoolean(R.bool.tablet);
    }
}
