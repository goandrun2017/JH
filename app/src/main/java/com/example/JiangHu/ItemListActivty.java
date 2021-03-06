package com.example.JiangHu;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.JiangHu.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by GR on 2017/2/10.
 */
public class ItemListActivty extends AppCompatActivity {

    private int type = -1;
    private int userID = -1;
    private String status = "";
    private String title = "";

    public MyTaskAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<TaskItem> taskList = new ArrayList<>();
    private int takerUserID = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_each_tab);
        type = getIntent().getIntExtra(Constant.TYPE, -1);
        status = getIntent().getStringExtra(Constant.STATUS);
        userID = getIntent().getIntExtra(Constant.USERID, -1);
        takerUserID = getIntent().getIntExtra(Constant.TAKERUSERID, -1);
        title = getIntent().getStringExtra(Constant.TITLE);
        TextView view = (TextView) findViewById(R.id.title);
        view.setVisibility(title.isEmpty() ? View.GONE : View.VISIBLE);
        view.setText(title);
        view.setVisibility(title.isEmpty() ? View.GONE : View.VISIBLE);
        initView();
    }

    protected void onResume() {
        super.onResume();
        refreshData();
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.each_swipe_refresh);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshData();
                                adapter.notifyDataSetChanged();
                                swipeRefreshLayout.setRefreshing(false);

                            }
                        });
                    }
                }).start();
            }
        });
        adapter = new MyTaskAdapter(this, taskList);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_recycler_view);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        refreshData();
    }

    public void refreshData()
    {
        taskList.clear();
        for (int i = 0; i < Constant.TaskFactory.size(); i++)
        {
            TaskItem taskItem = Constant.TaskFactory.get(i);
            if(type >= 0) {
                if(taskItem.getType() == type && taskItem.getStatus().equals(Constant.Status_standby)) {
                    taskList.add(taskItem);
                }
                continue;
            }
            if(takerUserID > 0 ) {
                if(taskItem.getTaker() == takerUserID && taskItem.getStatus().equals(status)) {
                    taskList.add(taskItem);
                }
                continue;
            }
            if(userID > 0 ) {
                if(taskItem.getUserID() == userID) {
                    taskList.add(taskItem);
                }
                continue;
            }
        }
        View view = findViewById(R.id.toolbar);
        view.setVisibility(title.isEmpty() ? View.GONE : View.VISIBLE);
        adapter.notifyDataSetChanged();
    }


}
