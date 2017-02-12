package com.example.JiangHu;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.JiangHu.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by GR on 2017/2/10.
 */
public class ItemListActivty extends AppCompatActivity {

    private int type = -1;
    public MyTaskAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<TaskItem> taskList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_each_tab);
        type = getIntent().getIntExtra(Constant.TYPE, -1);
        initView();
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.each_swipe_refresh);
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
    }

    public void refreshData()
    {
        taskList.clear();
        for (int i = 0; i < Constant.TaskFactory.size(); i++)
        {
            if (Constant.TaskFactory.get(i).getType() == type)
                taskList.add(Constant.TaskFactory.get(i));
        }

    }


}
