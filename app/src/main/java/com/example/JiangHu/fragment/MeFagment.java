package com.example.JiangHu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.example.JiangHu.Constant;
import com.example.JiangHu.MyTaskAdapter;
import com.example.JiangHu.R;
import com.example.JiangHu.MyProfileActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  Created by nick on 15/10/21.
 */
public class MeFagment extends Fragment {
    private GridView my_gridView_user;
    private RecyclerView recyclerView;
    //资源文件
    private int[] pic_path = {R.drawable.completed, R.drawable.ongoing, R.drawable.published, R.drawable.evaluated};
    private String[] texts = {"已完成","进行中","我发布的","待评价"};

    private ImageView myprofiles;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_user_profile, null);
        initView(view);
        return view;
    }


    private void initView(View view) {


        MyTaskAdapter adapter = new MyTaskAdapter(getContext(), Constant.TaskFactory.subList(3,8));
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_recommend_tasks);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        myprofiles = (ImageView) view.findViewById(R.id.profile_details);
        myprofiles.setClickable(true);
        myprofiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MyProfileActivity.class);
                startActivity(intent);

            }
        });


        my_gridView_user = (GridView) view.findViewById(R.id.gridview);

        List<Map<String, Object>> lstImageItem = new ArrayList<Map<String, Object>>();
        for(int i = 0 ; i < pic_path.length; ++i)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("taskImage",pic_path[i]);//添加图像资源的ID
            map.put("taskText", texts[i]);//按序号做ItemText
            lstImageItem.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),lstImageItem,R.layout.item_task_status,
                                 new String[] {"taskImage","taskText"},
                                 new int[]{R.id.taskImage,R.id.taskText});
        my_gridView_user.setAdapter(simpleAdapter);

    }

    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }
}
