package com.example.huawei.firstapp;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by huawei on 31/08/16.
 */
public class FragmentLifecycle extends Fragment {

    private static final String TAG = "lifecycle";

    private static final String SAVED_INSTANCES = "savedInstances";

    private int savedInstances;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onCreate()"));
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onStart()"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);


        if (savedInstanceState != null) {

            savedInstances = savedInstanceState.getInt(SAVED_INSTANCES, 0);
        }

        Log.d(TAG, String.format(" -> %s.%s | savedInstances = %d",
                getClassName(), "onCreateView()", savedInstances));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onResume()"));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onAttach()"));
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onDetach()"));
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onPause()"));
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onStop()"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, String.format(" -> %s.%s", getClassName(), "onDestroy()"));
    }

    public String getClassName() {
        String className = getClass().getName();
        return (className.substring(className.lastIndexOf(".") + 1));
    }
}
