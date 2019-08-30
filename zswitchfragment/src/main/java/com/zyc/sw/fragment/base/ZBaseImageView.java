package com.zyc.sw.fragment.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.zyc.sw.fragment.view.IView;

public class ZBaseImageView extends android.support.v7.widget.AppCompatImageView implements IView<ZImageViewData> {
    private final String TAG = this.getClass().getSimpleName();
    private ZImageViewData zImageViewData;

    public ZBaseImageView(Context context) {
        super(context);
        init(context, null);
    }

    public ZBaseImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZBaseImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    protected void init(Context context, AttributeSet attrs) {

    }

    @Override
    public void setChecked(boolean isChecked) {
        try {
            zImageViewData = getViewData();
            if(zImageViewData.selectResId != 0 && zImageViewData.normalResId != 0) {
                setImageResource(isChecked ? zImageViewData.selectResId : zImageViewData.normalResId);
            }
            if(zImageViewData.selectBackgroundId != 0 && zImageViewData.normalBackgroundId != 0) {
                setBackgroundResource(isChecked ? zImageViewData.selectBackgroundId : zImageViewData.normalBackgroundId);
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "资源未找到:" + e.getMessage());
        }
    }

    @Override
    public void initParams() {
        zImageViewData = getViewData();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
        if(params == null) {
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }
        if(getParent() != null && zImageViewData.imageWidth != 0 && zImageViewData.imageHeight != 0 && params.width != zImageViewData.imageWidth && params.height != zImageViewData.imageHeight) {
            params.width = zImageViewData.imageWidth;
            params.height = zImageViewData.imageHeight;
            setLayoutParams(params);
        }
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public ZImageViewData getViewData() {
        if(zImageViewData == null) {
            zImageViewData = new ZImageViewData();
        }
        return zImageViewData;
    }

    @Override
    public void setViewData(ZImageViewData zImageViewData) {
        this.zImageViewData = zImageViewData;
    }

}
