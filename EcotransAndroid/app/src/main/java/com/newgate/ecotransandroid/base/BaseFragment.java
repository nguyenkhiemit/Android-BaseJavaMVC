package com.newgate.ecotransandroid.base;


import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    public NavigationManager nav = NavigationManager.getInstance(getBaseActivity());

    public BaseActivity getBaseActivity() {
        return (BaseActivity)getActivity();
    }
}
