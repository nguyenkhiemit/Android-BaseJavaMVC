package com.newgate.ecotransandroid.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.WindowManager;

import com.newgate.ecotransandroid.R;

public class DialogLoading extends Dialog {

    public DialogLoading(@NonNull Context context) {
        super(context, R.style.SmoothProgressDialog);
        setContentView(R.layout.layout_loading);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.dimAmount = 0.7f;
        getWindow().setAttributes(lp);

        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }
}
