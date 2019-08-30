package com.zyc.view.lib;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyc.sw.fragment.ZCallback;
import com.zyc.sw.fragment.ZItemData;
import com.zyc.sw.fragment.base.ZBaseImageTextView;
import com.zyc.sw.fragment.base.ZBaseImageView;
import com.zyc.sw.fragment.base.ZImageTextData;
import com.zyc.sw.fragment.view.IView;
import com.zyc.sw.fragment.view.ZFlContainView;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment {

    private ZFlContainView zFlContainView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm3, null);
        zFlContainView2 = (ZFlContainView) view.findViewById(R.id.zFlContainView4);
        zFlContainView2.setData(getFragmentManager(), new Fragment4(), getData2());
        zFlContainView2.setCallback(new ZCallback() {
            @Override
            public void onClick(int index, ZItemData zViewData) {
                if(zViewData.fragment == null) {
                    zViewData.fragment = new Fragment5("四级菜单切换fragment"+ index);
                }
            }
        });
        return view;
    }

    private List<IView> getData2() {
        List<IView> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            ZBaseImageTextView btnView = new ZBaseImageTextView(getContext());
            ZImageTextData zImageTextData = null;
            switch(i) {
                case 0:
                    zImageTextData = new ZImageTextData.Builder()
                            .setText("四级菜单" + i)
                            .setTextColor(Color.BLACK, Color.RED)
                            .setDrawPadding(5)
                            .setTextSize(14)
                            .setSize(40,40)
                            .setImageBitmapResourceId(R.mipmap.num0_normal_new, R.mipmap.num0_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
                case 1:
                    zImageTextData = new ZImageTextData.Builder()
                            .setText("四级菜单" + i)
                            .setTextColor(Color.BLACK, Color.RED)
                            .setDrawPadding(5)
                            .setTextSize(14)
                            .setSize(40,40)
                            .setImageBitmapResourceId(R.mipmap.num1_normal_new, R.mipmap.num1_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
                case 2:
                    zImageTextData = new ZImageTextData.Builder()
                            .setText("四级菜单" + i)
                            .setTextColor(Color.BLACK, Color.RED)
                            .setDrawPadding(5)
                            .setTextSize(14)
                            .setSize(40,40)
                            .setImageBitmapResourceId(R.mipmap.num2_normal_new, R.mipmap.num2_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
            }
            btnView.setViewData(zImageTextData);
            list.add(btnView);
        }
        return list;
    }


}
