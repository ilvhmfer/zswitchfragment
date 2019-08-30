package com.zyc.view.lib;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment5 extends Fragment {

    private String msg;

    @SuppressLint("ValidFragment")
    public Fragment5(String msg) {
        this.msg = msg;
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("页面：" + msg);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.GRAY);
        return textView;
    }


}
