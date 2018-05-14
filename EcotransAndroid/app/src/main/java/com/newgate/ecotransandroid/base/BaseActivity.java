package com.newgate.ecotransandroid.base;

import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public NavigationManager nav = NavigationManager.getInstance(this);
}
