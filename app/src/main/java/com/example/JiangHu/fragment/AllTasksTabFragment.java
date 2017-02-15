package com.example.JiangHu.fragment;

import android.os.Bundle;

import com.example.JiangHu.Constant;
import com.example.JiangHu.TaskItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10038108 on 2017/2/13.
 */

public class AllTasksTabFragment extends EachTabFragment {
    @Override
    public List<TaskItem> refreshData() {
        List<TaskItem> taskList = new ArrayList<>();
        for (int i = 0; i < Constant.TaskFactory.size(); i++) {
            TaskItem taskItem = Constant.TaskFactory.get(i);
            if (!taskItem.getStatus().equals(Constant.Status_standby))
                continue;
            if (taskItem.getDistanceType() == mPage)
                taskList.add(taskItem);
        }
        return taskList;
    }

    public static AllTasksTabFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("page", page);
        AllTasksTabFragment fragment = new AllTasksTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
