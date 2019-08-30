package com.zyc.sw.fragment.view;

import android.view.View;
import android.widget.LinearLayout;

import com.zyc.sw.fragment.base.ZBaseViewData;

public interface IView<T extends ZBaseViewData> {

    View getView();

    T getViewData();

    void setViewData(T t);

    void setChecked(boolean isChecked);

    void initParams();

}
