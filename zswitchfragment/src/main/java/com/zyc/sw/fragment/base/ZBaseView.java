package com.zyc.sw.fragment.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.zyc.sw.fragment.view.IView;

public class ZBaseView<T extends ZBaseViewData> extends View implements IView {
    private ZBaseViewData zBaseViewData;

    public ZBaseView(Context context) {
        super(context);
    }

    public ZBaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZBaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View getView() {
        return this;
    }

    public ZBaseViewData getViewData() {
        if(zBaseViewData == null){
            zBaseViewData = new ZBaseViewData.Builder().build();
        }
        return zBaseViewData;
    }

    @Override
    public void setViewData(ZBaseViewData zBaseViewData) {
        this.zBaseViewData = zBaseViewData;
    }

    @Override
    public void setChecked(boolean isChecked) {

    }

    @Override
    public void initParams() {

    }

}
