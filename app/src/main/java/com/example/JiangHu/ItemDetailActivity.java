package com.example.JiangHu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailActivity extends AppCompatActivity {

    private static final String ARG_POSITION = "position";

    private int taskTtemID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskTtemID = getIntent().getIntExtra(Constant.ID, -1);
        setContentView(R.layout.item_detail);
        TextView person_name = (TextView) findViewById(R.id.person_name);
        TextView help_content = (TextView) findViewById(R.id.help_content);
        TextView price = (TextView) findViewById(R.id.price);
        TextView phone_number = (TextView) findViewById(R.id.phone_number);
        ImageView personImg = (ImageView) findViewById(R.id.iv_personImg);
        TaskItem taskItem = Constant.TaskFactory.get(taskTtemID);
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
                TaskItem taskItem = Constant.TaskFactory.get(taskTtemID);
                if(taskItem.getUserID() == 100)
                    Toast.makeText(ItemDetailActivity.this,"不能接受自己发布的任务!",Toast.LENGTH_SHORT).show();
                else {
                    taskItem.setTaker(Constant.ADMIN);
                    taskItem.setStatus(Constant.Status_doing);
//                  Constant.alterStatus(taskTtemID);
                    Toast.makeText(ItemDetailActivity.this, "接镖成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}