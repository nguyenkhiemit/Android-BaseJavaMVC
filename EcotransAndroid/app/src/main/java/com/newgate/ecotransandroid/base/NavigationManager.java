package com.newgate.ecotransandroid.base;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.newgate.ecotransandroid.R;

import java.util.Date;

public class NavigationManager {

    private static NavigationManager instance;

    public static NavigationManager getInstance(AppCompatActivity activity) {
        if(instance == null) {
            instance = new NavigationManager(activity);
        }
        return instance;
    }

    public NavigationManager(AppCompatActivity activity) {
        this.activity = activity;
        this.fragmentManager = activity.getSupportFragmentManager();
    }

    interface OnBackStackListener {
        void onBack();
    }

    private Activity activity;

    private FragmentManager fragmentManager;

    private Long preTime = 0L;

    public enum Type {
        ADD,
        REPLACE
    }

    public enum AnimationType {

        LEFT_RIGHT(200L),
        BOTTOM_TOP(400L);

        private Long duration;

        AnimationType(Long duration) {
            this.duration = duration;
        }
    }

    public void openFragment(@IdRes Integer containerId, Fragment fragment, Type type, AnimationType animationType) {
        if(animationType != null) {
            Date date = new Date();
            Long currTime = date.getTime();
            if(currTime - preTime > animationType.duration) {
                preTime = currTime;
            } else {
                return;
            }
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(findFragment(fragment.getClass().getSimpleName())) {
            goToFragment(fragment.getClass().getSimpleName());
        } else {
            if(animationType != null) {
                if(animationType == AnimationType.LEFT_RIGHT) {
                    transaction.setCustomAnimations(R.anim.slide_enter_left, R.anim.slide_exit_right, R.anim.slide_enter_right, R.anim.slide_exit_left);
                } else if(animationType == AnimationType.BOTTOM_TOP) {
                    transaction.setCustomAnimations(R.anim.slide_enter_bottom, R.anim.slide_exit_top,
                            R.anim.slide_enter_top, R.anim.slide_exit_bottom);
                }
            }
            if(type == Type.ADD) {
                transaction.add(containerId, fragment, fragment.getClass().getSimpleName());
            } else if(type == Type.REPLACE) {
                transaction.replace(containerId, fragment, fragment.getClass().getSimpleName());
            }
            transaction.addToBackStack(fragment.getClass().getSimpleName());
            transaction.commit();
        }
    }

    public Fragment getCurrentFragment(@IdRes Integer containerId) {
        return fragmentManager.findFragmentById(containerId);
    }

    public void listenerOnBackChanged(OnBackStackListener listener) {
        listener.onBack();
    }

    public void onBack() {
        fragmentManager.popBackStack();
        fragmentManager.executePendingTransactions();
    }

    public void backToRoot() {
        Integer count = backStackCount();
        while (count > 1) {
            count--;
            onBack();
        }
    }

    public Boolean isRoot() {
        return fragmentManager.getBackStackEntryCount() <= 1;
    }

    public void goToFragment(String tag) {
        Integer count = backStackCount();
        while (count > 1) {
            if(tag.equals(fragmentManager.getBackStackEntryAt(count - 1).getName())) {
                break;
            }
            count--;
            onBack();
        }
    }

    public Boolean findFragment(String tag) {
        if(fragmentManager.findFragmentByTag(tag) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Integer backStackCount() {
        return fragmentManager.getBackStackEntryCount();
    }

}
