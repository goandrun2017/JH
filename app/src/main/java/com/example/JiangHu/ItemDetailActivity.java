package com.example.JiangHu;

import android.content.Intent;
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

    private TaskItem taskItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int taskTtemID = getIntent().getIntExtra(Constant.ID, -1);
        setContentView(R.layout.item_detail);
        TextView person_name = (TextView) findViewById(R.id.person_name);
        TextView title = (TextView) findViewById(R.id.title);
        TextView help_content = (TextView) findViewById(R.id.help_content);
        TextView price = (TextView) findViewById(R.id.price);
        TextView phone_number = (TextView) findViewById(R.id.phone_number);
        ImageView personImg = (ImageView) findViewById(R.id.iv_personImg);

        taskItem = Constant.TaskFactory.get(taskTtemID);
        PersonInfo personInfo = Constant.personMap.get(taskItem.getUserID());
        person_name.setText(personInfo.getName());
        title.setText(taskItem.getTitle());
        help_content.setText(taskItem.getContent());
        price.setText("赏 "+ taskItem.getPayment());
        phone_number.setText("手机号码: "+ taskItem.getPhoneNumber());
        personImg.setImageResource(taskItem.getImageID());

        Button button1 = (Button) findViewById(R.id.btn_task_acceptance);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        personImg.setClickable(true);
        personImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailActivity.this, MyProfileActivity.class);
                intent.putExtra(Constant.USERID, taskItem.getUserID());
                startActivity(intent);
            }
        });
        person_name.setClickable(true);
        person_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailActivity.this, MyProfileActivity.class);
                intent.putExtra(Constant.USERID, taskItem.getUserID());
                startActivity(intent);
            }
        });
    }
}