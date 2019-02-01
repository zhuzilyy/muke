package com.muke.app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muke.app.R;
import com.muke.app.fragment.base.BaseFragment;

public class MineFragment extends BaseFragment {
    private View mContentView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_mine_layout,null);
        return mContentView;
    }
}
