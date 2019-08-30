package com.zyc.view.lib;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyc.sw.fragment.ZCallback;
import com.zyc.sw.fragment.ZItemData;
import com.zyc.sw.fragment.base.ZBaseTextView;
import com.zyc.sw.fragment.base.ZBaseView;
import com.zyc.sw.fragment.base.ZImageTextData;
import com.zyc.sw.fragment.view.IView;
import com.zyc.sw.fragment.view.ZFlContainView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    private ZFlContainView zFlContainView2;
    private String[] strings = new String[]{"A", "B", "C", "D"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm, null);
        zFlContainView2 = (ZFlContainView) view.findViewById(R.id.zFlContainView2);
        zFlContainView2.setData(getFragmentManager(), new Fragment2(), getData2());
        zFlContainView2.setCallback(new ZCallback() {
            @Override
            public void onClick(int index, ZItemData zViewData) {
                if(zViewData.fragment == null) {
                    zViewData.fragment = new Fragment5("二级菜单切换fragment"+ index);
                }
            }
        });
        return view;
    }

    private List<IView> getData2() {
        List<IView> list = new ArrayList<>();
        for(String str : strings) {
            ZBaseTextView btnView = new ZBaseTextView(getContext());
            ZImageTextData zImageTextData = new ZImageTextData.Builder().setText("二级菜单" + str).setTextColor(Color.BLACK, Color.RED).setGravity(Gravity.CENTER).build();
            btnView.setViewData(zImageTextData);
            list.add(btnView);
        }
        return list;
    }
}
