package com.example.JiangHu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.JiangHu.BannerModel;
import com.example.JiangHu.MainActivity;
import com.example.JiangHu.MyTaskAdapter;
import com.example.JiangHu.R;
import com.example.JiangHu.TaskItem;
import com.example.JiangHu.grid.MyGridAdapter;
import com.example.JiangHu.grid.MyGridView;
import com.sivin.Banner;
import com.sivin.BannerAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.JiangHu.Constant.TAGS;

/**
 * Created by zhibinxiao on 2017/2/2.
 */

public class HomeFragment extends Fragment
{

   // private SwipeRefreshLayout swipeRefresh;

    private MyGridView myGridView;

    private Banner mBanner;

    private List<BannerModel> imgs = new ArrayList<BannerModel>();


    //private MyTaskAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);

        buildupBanner(view);
        buildupGrid(view);


//
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        //设置adapter
//        adapter = new MyTaskAdapter(getContext(),getNewsList());
//        recyclerView.setAdapter(adapter);
//        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
//        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
//        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshFruits();
//            }
//        });

        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.task_view,new TaskListTabFrament());
        ft.commit();

        return view;
    }

    /*
    public String[] img_text = ;
    public int[] imgs = ;
    */
    private void buildupGrid(View view) {
        myGridView=(MyGridView) view.findViewById(R.id.gridview);
        MyGridAdapter adapter = new MyGridAdapter(getContext());
        adapter.setImg_text(new String[]{ "上课考试", "跑腿救急", "鹊桥交友", "求职面试", "游戏互动", "资源共享",
                "二手交易", "兼职代理" });
        adapter.setImgs(new int[]{R.mipmap.menu1, R.mipmap.menu2,
                R.mipmap.menu3, R.mipmap.menu4,
                R.mipmap.menu5, R.mipmap.menu6,
                R.mipmap.menu7, R.mipmap.menu8});
        myGridView.setAdapter(adapter);
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"adf",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void buildupBanner(View view)
    {
        mBanner = (Banner) view.findViewById(R.id.id_banner);


        BannerModel bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title1);
        bannerModel.setTips("江湖秘籍");
        imgs.add(bannerModel);

        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title2);
        bannerModel.setTips("昭告天下");
        imgs.add(bannerModel);


        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title3);
        bannerModel.setTips("生财有道");
        imgs.add(bannerModel);

        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title4);
        bannerModel.setTips("人在江湖");
        imgs.add(bannerModel);

        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title5);
        bannerModel.setTips("海纳百川");
        imgs.add(bannerModel);


        BannerAdapter adapter = new BannerAdapter<BannerModel>(imgs) {
            @Override
            protected void bindTips(TextView tv, BannerModel bannerModel) {
                tv.setText(bannerModel.getTips());
            }
            @Override
            public void bindImage(ImageView imageView, BannerModel bannerModel) {
                Glide.with(getActivity())
                        .load(bannerModel.getImageId())
                        .placeholder(R.mipmap.empty)
                        .error(R.mipmap.error)
                        .fitCenter()
                        .into(imageView);
            }
        };

        mBanner.setOnBannerItemClickListener(new Banner.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position != 0){
                    Toast.makeText(getContext(), imgs.get(position).getTips()+" 建设中",Toast.LENGTH_SHORT).show();
                }
                else {
                    FragmentManager fm = ((MainActivity)getContext()).getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment fragment2 = fm.findFragmentByTag(TAGS[1]);
                    if (fragment2 == null) {
                        fragment2 = new TaskListTabFrament();
                        ft.add(R.id.content_frame, fragment2, TAGS[1]);
                    } else {
                        ft.show(fragment2);
                    }
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });
        mBanner.setBannerAdapter(adapter);
        mBanner.notifiDataHasChanged();
    }




//    private void refreshFruits() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        adapter.notifyDataSetChanged();
//                        swipeRefresh.setRefreshing(false);
//                    }
//                });
//            }
//        }).start();
//    }

    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }

}
