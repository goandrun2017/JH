package com.example.JiangHu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.JiangHu.fragment.HomeFragment;
import com.example.JiangHu.fragment.MeFagment;
import com.example.JiangHu.fragment.TaskCommitFragment;
import com.example.JiangHu.fragment.TaskListTabFrament;

import static com.example.JiangHu.Constant.TAGS;
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    private RadioGroup mHomeRadioGroup;
    private RadioButton mHomeHomeRb;
    private RadioButton mHomeDiscoverRb;
    private RadioButton mHomePublishRb;
    private RadioButton mHomeInfoRb;
    private RadioButton mHomeMeRb;

    private FrameLayout mHomeContent;

    static final int NUM_ITEMS = 5;//一共6个fragment
    //用adapter来管理三个Fragment界面的变化。注意，我这里用的Fragment都是v4包里面的
  //  FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

      //  @Override
  //      public int getCount() {
      //      return 4;//一共有四个Fragment
     //   }

//        //进行Fragment的初始化
//        @Override
//        public Fragment getItem(int i) {
//            Fragment fragment = null;
//
//            switch (i) {
//                case 0://首页
//                    fragment = new HomeFragment();
//                    break;
//                case 1:
//                    fragment = new TaskListTabFrament();
//                    break;
//                case 2:
//                    fragment = new TaskCommitFragment();
//                    break;
//
//                default:
//                    new HomeFragment();
//                    break;
//            }
//            if (fragment == null) {
//                fragment = new HomeFragment();
//            }
//            return fragment;
//        }
    //};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();

        mHomeContent = (FrameLayout) findViewById(R.id.content_frame); //tab上方的区域

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });


        mHomeRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);  //底部的四个tab
        mHomeHomeRb = (RadioButton) findViewById(R.id.radio_home);
        mHomeDiscoverRb = (RadioButton) findViewById(R.id.radio_discover);
        mHomePublishRb = (RadioButton) findViewById(R.id.radio_publish);
        mHomeInfoRb = (RadioButton) findViewById(R.id.radio_info);
        mHomeMeRb = (RadioButton) findViewById(R.id.radio_me);

        mHomeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment1 = fm.findFragmentByTag(TAGS[0]);
                Fragment fragment2 = fm.findFragmentByTag(TAGS[1]);
                Fragment fragment3 = fm.findFragmentByTag(TAGS[2]);
                Fragment fragment4 = fm.findFragmentByTag(TAGS[3]);
                Fragment fragment5 = fm.findFragmentByTag(TAGS[4]);
                if (fragment1 != null) {
                    ft.hide(fragment1);
                }
                if (fragment2 != null) {
                    ft.hide(fragment2);
                }
                if (fragment3 != null) {
                    ft.hide(fragment3);
                }
                if (fragment4 != null) {
                    ft.hide(fragment4);
                }
                if (fragment5 != null) {
                    ft.hide(fragment5);
                }
                switch (checkedId) {
                    case R.id.radio_home:
                        if (fragment1 == null) {
                            fragment1 = new HomeFragment();
                            ft.add(R.id.content_frame, fragment1, TAGS[0]);
                        } else {
                            ft.show(fragment1);
                        }
                        break;
                    case R.id.radio_discover:
                        if (fragment2 == null) {
                            fragment2 = new TaskListTabFrament();
                            ft.add(R.id.content_frame, fragment2, TAGS[1]);
                        } else {
                            ft.show(fragment2);
                        }
                        break;
                    case R.id.radio_publish:
                        if (fragment3 == null) {
                            fragment3 = new TaskCommitFragment();
                            ft.add(R.id.content_frame, fragment3, TAGS[2]);
                        } else {
                            ft.show(fragment3);
                        }
                        break;
                    case R.id.radio_info:
                        if (fragment4 == null) {
                            fragment4 = new HomeFragment();
                            ft.add(R.id.content_frame, fragment4, TAGS[3]);
                        } else {
                            ft.show(fragment4);
                        }
                        break;

                    case R.id.radio_me:
                        if (fragment5 == null) {
                            fragment5 = new MeFagment();
                            ft.add(R.id.content_frame, fragment5, TAGS[4]);
                        } else {
                            ft.show(fragment5);
                        }
                    default:
                        break;
                }
				ft.commit();
                MainActivity.this.checkIndexActivity(checkedId);
                //通过fragments这个adapter还有index来替换帧布局中的内容
                //Fragment fragment = (Fragment) fragments.instantiateItem(mHomeContent, index);
                //一开始将帧布局中 的内容设置为第一个
                //fragments.setPrimaryItem(mHomeContent, 0, fragment);
                //fragments.finishUpdate(mHomeContent);
            }
        });
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, TAGS[0]).commit();

        }
        Intent intent = new Intent(this, LoginActivity.class);
//        Intent intent1 = new Intent(this, MyImageActivity.class);
        startActivity(intent);
    }

    public void checkIndexActivity(int index){
        Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
        switch (index) {
            case R.id.radio_info://消息
                intent.putExtra("select", R.drawable.demo_info);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("深圳大学");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

//
//    protected void onStart() {
//        super.onStart();
//        mHomeRadioGroup.check(R.id.radio_home);
//    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < mHomeRadioGroup.getChildCount(); i++) {
            RadioButton mTab = (RadioButton) mHomeRadioGroup.getChildAt(i);
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag((String) mTab.getTag());
            FragmentTransaction ft = fm.beginTransaction();
            if (fragment != null) {
                if (!mTab.isChecked()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }

}
