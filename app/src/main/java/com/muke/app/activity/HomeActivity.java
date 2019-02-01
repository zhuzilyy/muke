package com.muke.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.muke.app.R;
import com.muke.app.activity.base.BaseActivity;
import com.muke.app.fragment.HomeFragment;
import com.muke.app.fragment.MessageFragment;
import com.muke.app.fragment.MineFragment;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;
    private FragmentManager fragmentManager;
    private Fragment currentFragment=new Fragment();
    @BindView(R.id.bar)
    public BottomNavigationBar bar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void initViews() {
        fragmentManager=getSupportFragmentManager();
        homeFragment =new HomeFragment();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        AddOrShowFra(ft,homeFragment);

        bar.setMode(BottomNavigationBar.MODE_FIXED);
        bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        bar.addItem(new BottomNavigationItem(getResources().getDrawable(R.mipmap.choosenews_icon),"新闻").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(getResources().getDrawable(R.mipmap.choosevideo_icon),"视频").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(getResources().getDrawable(R.mipmap.nonemy_icon),"我的").setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0).initialise();
        bar.setTabSelectedListener(this);
    }
    @Override
    protected void initData() {

    }
    @Override
    protected void getResLayout() {
        setContentView(R.layout.activity_home_layout);
    }

    @Override
    protected void initListener() {

    }

    /***
     * 显示隐藏Fragment
     *
     * @param ft
     * @param Fra
     */
    private void AddOrShowFra(FragmentTransaction ft, Fragment Fra) {
        if (currentFragment == Fra) {
            return;
        }
        if (!Fra.isAdded()) {
            ft.hide(currentFragment).add(R.id.main_switch, Fra).commitAllowingStateLoss();

        } else {
            ft.hide(currentFragment).show(Fra).commitAllowingStateLoss();
        }
        currentFragment = Fra;
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction ft=fragmentManager.beginTransaction();
        switch(position ){
            case 0:
                if(homeFragment == null){
                    homeFragment = new HomeFragment();
                }
                AddOrShowFra(ft,homeFragment);
                break;
            case 1:
                if(messageFragment == null){
                    messageFragment = new MessageFragment();
                }
                AddOrShowFra(ft,messageFragment);
                break;
            case 2:
                if(mineFragment == null){
                    mineFragment=new MineFragment();
                }
                AddOrShowFra(ft,mineFragment);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
