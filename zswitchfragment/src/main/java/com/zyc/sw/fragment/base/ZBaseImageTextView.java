package com.zyc.sw.fragment.base;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyc.sw.fragment.view.IView;

public class ZBaseImageTextView extends LinearLayout implements IView<ZImageTextData> {
    private final String TAG = this.getClass().getSimpleName();
    private ZImageTextData zImageTextData;
    private ImageView imageView;
    private TextView textView;

    public ZBaseImageTextView(Context context) {
        super(context);
        init(context, null);
    }

    public ZBaseImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZBaseImageTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    protected void init(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        //
        zImageTextData = getViewData();
        imageView = new ImageView(context);
        if(zImageTextData.normalResId != 0) {
            imageView.setImageResource(zImageTextData.normalResId);
        }
        addView(imageView);
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        addView(textView);
    }

    @Override
    public void initParams() {
        zImageTextData = getViewData();
        LinearLayout.LayoutParams params = (LayoutParams) imageView.getLayoutParams();
        if(params == null) {
            params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        }
        params.gravity = Gravity.CENTER;
        if(zImageTextData.imageWidth != 0 && zImageTextData.imageHeight != 0) {
            params.width = zImageTextData.imageWidth;
            params.height = zImageTextData.imageHeight;
        }
        imageView.setLayoutParams(params);
        //
        LinearLayout.LayoutParams params2 = (LayoutParams) textView.getLayoutParams();
        if(params2 == null) {
            params2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        }
        params2.gravity = Gravity.CENTER;
        if(zImageTextData.selectTextColor != 0 && zImageTextData.normalTextColor != 0) {
            textView.setTextColor(zImageTextData.normalTextColor);
        }
        params2.topMargin = zImageTextData.drawPadding;
        textView.setLayoutParams(params2);
        textView.setTextSize(zImageTextData.textSize);
        if(!TextUtils.isEmpty(zImageTextData.text)) {
            textView.setText(zImageTextData.text);
        }
    }

    @Override
    public void setChecked(boolean isChecked) {
        try {
            zImageTextData = getViewData();
            if(zImageTextData.selectResId != 0 && zImageTextData.normalResId != 0) {
                imageView.setImageResource(isChecked ? zImageTextData.selectResId : zImageTextData.normalResId);
            }
            if(zImageTextData.selectBackgroundId != 0 && zImageTextData.normalBackgroundId != 0) {
                setBackgroundResource(isChecked ? zImageTextData.selectBackgroundId : zImageTextData.normalBackgroundId);
            }
            if(zImageTextData.selectTextColor != 0 && zImageTextData.normalTextColor != 0) {
                textView.setTextColor(isChecked ? zImageTextData.selectTextColor : zImageTextData.normalTextColor);
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "资源未找到:" + e.getMessage());
        }
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public ZImageTextData getViewData() {
        if(zImageTextData == null) {
            zImageTextData = new ZImageTextData();
        }
        return zImageTextData;
    }

    @Override
    public void setViewData(ZImageTextData zImageViewData) {
        this.zImageTextData = zImageViewData;
    }

}
