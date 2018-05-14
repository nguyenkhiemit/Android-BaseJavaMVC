package com.newgate.ecotransandroid.view;

import android.content.Context;

public class DialogUtils {

    private static DialogLoading progressLoading;

    public static void show(Context context) {
        release();
        if(progressLoading == null) {
            progressLoading = new DialogLoading(context);
        }
        progressLoading.show();
    }

    public static void hide() {
        if(progressLoading != null && progressLoading.isShowing()) {
            progressLoading.dismiss();
        }
    }

    public static void release() {
        hide();
        progressLoading = null;
    }

}
