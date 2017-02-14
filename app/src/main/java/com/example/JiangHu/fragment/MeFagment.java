package com.example.JiangHu.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.JiangHu.Constant;
import com.example.JiangHu.ItemListActivty;
import com.example.JiangHu.MainActivity;
import com.example.JiangHu.MyProfileActivity;
import com.example.JiangHu.MyTaskAdapter;
import com.example.JiangHu.MyTaskListActivity;
import com.example.JiangHu.R;
import com.example.JiangHu.grid.MyGridAdapter;

import java.util.ArrayList;


/**
 *  Created by nick on 15/10/21.
 */
public class MeFagment extends Fragment {
    private GridView my_gridView_user;
    private RecyclerView recyclerView;
    //资源文件
    private int[] pic_path = {R.drawable.completed, R.drawable.ongoing, R.drawable.published, R.drawable.evaluated};
    private String[] texts = {"已完成","进行中","我发布的","待评价"};



    private ImageView myprofiles,myalltasks;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_user_profile, null);
        initView(view);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity activity = (MainActivity) getActivity();
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
    }

    private void initView(View view)
    {

        final MyTaskAdapter adapter = new MyTaskAdapter(getContext(), new ArrayList<>(Constant.TaskFactory.subList(3,8)));
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


        my_gridView_user = (GridView) view.findViewById(R.id.static_grid_view);
        MyGridAdapter gridAdapter = new MyGridAdapter(getContext());
        gridAdapter.setImg_text(texts);
        gridAdapter.setImgs(pic_path);
        my_gridView_user.setNumColumns(texts.length);
        my_gridView_user.setAdapter(gridAdapter);
        my_gridView_user.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ItemListActivty.class);
                intent.putExtra(Constant.TITLE, texts[position]);
                switch (position) {
                    case 0:
                        intent.putExtra(Constant.TAKERUSERID, 100);
                        intent.putExtra(Constant.STATUS, Constant.Status_done);
                        break;
                    case 1:
                        intent.putExtra(Constant.TAKERUSERID, 100);
                        intent.putExtra(Constant.STATUS, Constant.Status_doing);
                        break;
                    case 2:
                        intent.putExtra(Constant.USERID, 100);
                        break;
                    case 3:
                        intent.putExtra(Constant.TAKERUSERID, 100);
                        intent.putExtra(Constant.STATUS, Constant.Status_evaluate);
                        break;
                    default:
                        intent.putExtra(Constant.STATUS, Constant.Status_done);
                }
                getContext().startActivity(intent);
            }
        });

        myalltasks = (ImageView) view.findViewById(R.id.my_all_tasks);
        myalltasks.setClickable(true);
        myalltasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MyTaskListActivity.class);
                startActivity(intent);
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.recommend_swipe_refresh);
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
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                adapter.notifyDataSetChanged();
                                swipeRefreshLayout.setRefreshing(false);

                            }
                        });
                    }
                }).start();
            }
        });
    }

    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }
}
