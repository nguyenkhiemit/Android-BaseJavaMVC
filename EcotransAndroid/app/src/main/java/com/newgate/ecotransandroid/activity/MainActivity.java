package com.newgate.ecotransandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.newgate.ecotransandroid.R;
import com.newgate.ecotransandroid.base.BaseActivity;
import com.newgate.ecotransandroid.base.NavigationManager;
import com.newgate.ecotransandroid.fragment.FragmentA;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav.openFragment(R.id.layout_contaier, new FragmentA(), NavigationManager.Type.ADD, NavigationManager.AnimationType.LEFT_RIGHT);
    }
}
