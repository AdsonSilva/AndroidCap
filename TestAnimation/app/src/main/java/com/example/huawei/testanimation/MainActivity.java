package com.example.huawei.testanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void anima(View v){
        ImageView foto = (ImageView) findViewById(R.id.img);

        if(foto.getVisibility() == View.GONE){
            foto.setVisibility(View.VISIBLE);
        }else {
            foto.setVisibility(View.GONE);
        }
    }
}
