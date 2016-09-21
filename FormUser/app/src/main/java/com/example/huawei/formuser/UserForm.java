package com.example.huawei.formuser;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by huawei on 20/09/16.
 */
public class UserForm extends Fragment {

    private EditText birthDate, name, email, password, login;
    private Button save;
    private AppCompatActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_user, container, false);

        this.name = (EditText) view.findViewById(R.id.nameEdt);
        this.login = (EditText) view.findViewById(R.id.loginEdt);
        this.email = (EditText) view.findViewById(R.id.emailEdt);
        this.password = (EditText) view.findViewById(R.id.passwordEdt);
        this.birthDate = (EditText) view.findViewById(R.id.nascEdt);
        this.save = (Button) view.findViewById(R.id.btnSave);

        save.setOnClickListener(btnSaveClickedListenner());

        return view;
    }

    public View.OnClickListener btnSaveClickedListenner(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(name.getText().toString(), login.getText().toString(), email.getText().toString(),
                        birthDate.getText().toString(), password.getText().toString());

                try{
                    ((OnUserSavedListener) activity).onUserSaved(user);
                } catch (ClassCastException e){
                    throw new ClassCastException(activity.toString() + " deve implementar OnUserSavedListener");
                }
            }
        };
    }

    public interface OnUserSavedListener{
        void onUserSaved(User user);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.activity = (AppCompatActivity) context;
    }





    public static UserForm newInstance(){
        UserForm fragment = new UserForm();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


}
