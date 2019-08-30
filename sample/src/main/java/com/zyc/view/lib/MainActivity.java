package com.zyc.view.lib;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zyc.sw.fragment.base.ZBaseTextView;
import com.zyc.sw.fragment.base.ZBaseViewData;
import com.zyc.sw.fragment.ZCallback;
import com.zyc.sw.fragment.ZItemData;
import com.zyc.sw.fragment.base.ZImageTextData;
import com.zyc.sw.fragment.view.IView;
import com.zyc.sw.fragment.view.ZFlContainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ZFlContainView zFlContainView;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        zFlContainView = (ZFlContainView) findViewById(R.id.zFlContainView);
        zFlContainView.setData(getSupportFragmentManager(), new Fragment1(), getData());
        zFlContainView.setCallback(new ZCallback() {
            @Override
            public void onClick(int index, ZItemData zViewData) {
                if(zViewData.fragment == null){
                    zViewData.fragment = new Fragment5("一级菜单切换fragment" + index);
                }
            }
        });
    }


    private List<IView> getData() {
        List<IView> list = new ArrayList<>();
        ZBaseTextView zBaseTextView1 = new ZBaseTextView(mActivity);
        ZImageTextData zImageTextData = new ZImageTextData.Builder().setText("菜单1").setTextColor(Color.WHITE, Color.RED).setGravity(Gravity.CENTER).build();
        zBaseTextView1.setViewData(zImageTextData);
        list.add(zBaseTextView1);
        //
        ZBaseTextView zBaseTextView2 = new ZBaseTextView(mActivity);
        ZImageTextData zImageTextData2 = new ZImageTextData.Builder().setText("菜单2").setTextColor(Color.WHITE, Color.RED).setGravity(Gravity.CENTER).build();
        zBaseTextView2.setViewData(zImageTextData2);
        list.add(zBaseTextView2);
        return list;
    }
}
