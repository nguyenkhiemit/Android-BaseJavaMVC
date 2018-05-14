package com.newgate.ecotransandroid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newgate.ecotransandroid.R;
import com.newgate.ecotransandroid.base.BaseFragment;
import com.newgate.ecotransandroid.base.NavigationManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentB extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.img_back)
    public void onBack() {
        nav.onBack();
    }

    @OnClick(R.id.btn_next)
    public void onNext() {
        nav.openFragment(R.id.layout_contaier, new FragmentC(), NavigationManager.Type.ADD, NavigationManager.AnimationType.LEFT_RIGHT);
    }
}
