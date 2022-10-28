package com.demo.test;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageItemView extends LinearLayout {
    public ImageView imageView;

    public ImageItemView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        int phoneWidth = ScreenUtil.getPhoneWidth((Activity) context);
        int i = (phoneWidth-ScreenUtil.dip2px(context,16)) / 4;
        imageView = new ImageView(context);
        LayoutParams params = new LayoutParams(i, i);
        params.setMargins(ScreenUtil.dip2px(context,2), ScreenUtil.dip2px(context,2), ScreenUtil.dip2px(context,2), ScreenUtil.dip2px(context,2));
        addView(imageView, params);
    }

}
