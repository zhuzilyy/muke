package com.muke.app.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity  extends AppCompatActivity{
    Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConfigure();
    }
    private void initConfigure() {
        //加载布局
        getResLayout();
        unbinder= ButterKnife.bind(this);
        //初始化控件
        initViews();
        //初始化数据
        initData();
        initListener();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
    protected abstract void initViews();
    protected abstract void initData();
    protected abstract void getResLayout();
    protected abstract void initListener();
}
