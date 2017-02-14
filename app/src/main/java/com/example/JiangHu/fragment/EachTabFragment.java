package com.example.JiangHu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.JiangHu.Constant;
import com.example.JiangHu.MyTaskAdapter;
import com.example.JiangHu.R;
import com.example.JiangHu.TaskItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibinxiao on 2017/2/2.
 */

public abstract class EachTabFragment extends Fragment {

    public MyTaskAdapter adapter;

    protected int mPage;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String title;


    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt("page");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_each_tab, container, false);
        View view = rootView.findViewById(R.id.toolbar);
        view.setVisibility(View.GONE);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.each_swipe_refresh);
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

                                refreshData();
                                adapter.notifyDataSetChanged();
                                swipeRefreshLayout.setRefreshing(false);

                            }
                        });
                    }
                }).start();
            }
        });

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);

        refreshData();
        adapter = new MyTaskAdapter(getContext(),refreshData());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

    public  abstract List<TaskItem> refreshData();


    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }


}
