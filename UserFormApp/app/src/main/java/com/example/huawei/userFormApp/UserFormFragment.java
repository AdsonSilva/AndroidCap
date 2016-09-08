package com.example.huawei.userFormApp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huawei.exemploaula4.R;

/**
 * Created by huawei on 08/09/16.
 */
public class UserFormFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.form_user, container, false);

        return view;
    }

    public static UserFormFragment newInstance(){
        UserFormFragment fragment = new UserFormFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }
}
