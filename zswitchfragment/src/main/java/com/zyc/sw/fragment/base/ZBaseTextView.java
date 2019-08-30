package com.zyc.sw.fragment.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.zyc.sw.fragment.view.IView;

public class ZBaseTextView extends android.support.v7.widget.AppCompatTextView implements IView<ZImageTextData> {
    private ZImageTextData zImageTextData;

    public ZBaseTextView(Context context) {
        super(context);
        init(context, null);
    }

    public ZBaseTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZBaseTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    protected void init(Context context, AttributeSet attrs) {
        setGravity(Gravity.CENTER);
    }

    @Override
    public void setChecked(boolean isChecked) {
        zImageTextData = getViewData();
        try {
            if(zImageTextData.selectTextColor != 0 && zImageTextData.normalTextColor != 0) {
                setTextColor(isChecked ? zImageTextData.selectTextColor : zImageTextData.normalTextColor);
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initParams() {
        zImageTextData = getViewData();
        if(!TextUtils.isEmpty(zImageTextData.text)) {
            setText(zImageTextData.text);
        }
        if(zImageTextData.normalTextColor != 0) {
            setTextColor(zImageTextData.normalTextColor);
        }
        if(zImageTextData.textSize != 0) {
            setTextSize(zImageTextData.textSize);
        }
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public ZImageTextData getViewData() {
        if(zImageTextData == null) {
            zImageTextData = new ZImageTextData.Builder().build();
        }
        return zImageTextData;
    }

    @Override
    public void setViewData(ZImageTextData zBaseViewData) {
        zImageTextData = zBaseViewData;
    }

}
