package com.example.JiangHu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailActivity extends AppCompatActivity {

    private static final String ARG_POSITION = "position";

    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getIntent().getIntExtra(Constant.ID, -1);
        setContentView(R.layout.item_detail);
        TextView person_name = (TextView) findViewById(R.id.person_name);
        TextView help_content = (TextView) findViewById(R.id.help_content);
        TextView price = (TextView) findViewById(R.id.price);
        TextView phone_number = (TextView) findViewById(R.id.phone_number);
        ImageView personImg = (ImageView) findViewById(R.id.iv_personImg);
        TaskItem taskItem = Constant.TaskFactory.get(id);
        PersonInfo personInfo = (PersonInfo) Constant.personMap.get(taskItem.getUserID());
        person_name.setText(personInfo.getName());
        help_content.setText(taskItem.getContent());
        price.setText("赏 "+taskItem.getPayment());
        phone_number.setText("手机号码: "+taskItem.getPhoneNumber());
        personImg.setImageResource(taskItem.getImageID());


        TextView name = (TextView) findViewById(R.id.person_name);
        Button button1 = (Button) findViewById(R.id.btn_task_acceptance);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemDetailActivity.this,"接镖成功",Toast.LENGTH_SHORT).show();
                Constant.alterStatus(id);
                finish();


            }
        });
    }
}