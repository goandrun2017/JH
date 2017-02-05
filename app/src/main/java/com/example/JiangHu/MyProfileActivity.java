package com.example.JiangHu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.JiangHu.R;

/**
 * Created by zhibinxiao on 2017/1/24.
 */

public class MyProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Integer picID = intent.getIntExtra("select", 0);
        if(picID != 0){
            setContentView(R.layout.splash);
            ImageView myprofiles = (ImageView) findViewById(R.id.splashImage);
            myprofiles.setBackgroundResource(picID);
            myprofiles.setClickable(true);
            myprofiles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else{
            setContentView(R.layout.my_profile_layout);
        }
    }
}
