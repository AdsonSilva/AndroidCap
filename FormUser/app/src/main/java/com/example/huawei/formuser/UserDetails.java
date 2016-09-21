package com.example.huawei.formuser;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by huawei on 21/09/16.
 */
public class UserDetails extends Fragment implements UserForm.OnUserSavedListener{

    TextView birthDate, name, login, email, password;
    private static final String USER_PARAM = "user_param";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_informations, container, false);

        this.birthDate = (TextView) view.findViewById(R.id.nascView);
        this.login = (TextView) view.findViewById(R.id.loginView);
        this.name = (TextView) view.findViewById(R.id.nameView);
        this.password = (TextView) view.findViewById(R.id.passwordView);
        this.email = (TextView) view.findViewById(R.id.emailView);
        if(getArguments() != null && !(getArguments().isEmpty())){
            Bundle args = getArguments();

            Serializable user = args.getSerializable(USER_PARAM);

            setViewValues((User) user);
        }

        return view;

    }

    public void setViewValues(User user){
        if (user != null){
            this.name.setText(user.getName());
            this.email.setText(user.getEmail());
            this.login.setText(user.getLogin());
            this.password.setText(user.getPassword());
            this.birthDate.setText(user.getBirthDate());
        }
    }

    public static UserDetails newInstance(){
        UserDetails fragment = new UserDetails();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;

    }

    public static UserDetails newInstance(User user){
        UserDetails fragment = new UserDetails();
        Bundle args = new Bundle();
        args.putSerializable(USER_PARAM, user);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onUserSaved(User user) {

        setViewValues(user);

    }
}
