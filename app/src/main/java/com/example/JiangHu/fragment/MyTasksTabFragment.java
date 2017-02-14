package com.example.JiangHu.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.JiangHu.Constant;
import com.example.JiangHu.R;
import com.example.JiangHu.TaskItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.JiangHu.Constant.TaskFactory;

/**
 * Created by 10038108 on 2017/2/13.
 */

public class MyTasksTabFragment extends EachTabFragment {

    public static MyTasksTabFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("page", page);
        MyTasksTabFragment fragment = new MyTasksTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public List<TaskItem> refreshData()
    {
        List<TaskItem> taskList = new ArrayList<>();
        for(TaskItem item: Constant.TaskFactory)
        {
            if (mPage == 0 && item.getUserID()== 100)
            {
                taskList.add(item);
            }
            else
            {
                if (item.getTaker() ==100)
                {
                    taskList.add(item);
                }
            }
        }
        return taskList;
    }
}
