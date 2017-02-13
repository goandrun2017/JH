package com.example.JiangHu;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.JiangHu.fragment.AllTasksTabFragment;
import com.example.JiangHu.fragment.MyTasksTabFragment;

/**
 * Created by 10038108 on 2017/2/13.
 */

public class MyTaskListActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytasklist);
        viewPager = (ViewPager) findViewById(R.id.tasklist_viewpager);
        PagerAdapter pagerAdapter = new TaskViewPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.mytasklist_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }

    class TaskViewPagerAdapter extends FragmentStatePagerAdapter
    {
        String tabTitles[] = new String[]{"发布的任务", "接受的任务"};
        Context context;
        public TaskViewPagerAdapter(FragmentManager fm, Context context) {

            super(fm);
            this.context = context;
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MyTasksTabFragment.newInstance(0);
                case 1:
                    return MyTasksTabFragment.newInstance(1);
                default:
                    return MyTasksTabFragment.newInstance(0);
            }
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
    }


}