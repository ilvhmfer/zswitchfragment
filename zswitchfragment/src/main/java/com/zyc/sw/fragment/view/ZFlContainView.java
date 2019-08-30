package com.zyc.sw.fragment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.zyc.sw.fragment.R;
import com.zyc.sw.fragment.base.ZBaseViewData;
import com.zyc.sw.fragment.ZCallback;
import com.zyc.sw.fragment.ZConfig;
import com.zyc.sw.fragment.ZItemData;
import com.zyc.sw.fragment.base.ZImageViewData;
import com.zyc.sw.fragment.util.DpUtil;

import java.util.ArrayList;
import java.util.List;


public class ZFlContainView extends LinearLayout {
    private final String TAG = this.getClass().getSimpleName();
    private FrameLayout mFrameLayout;
    private LinearLayout mFlBtnGroup;
    private LinearLayout.LayoutParams childParams;
    private LinearLayout.LayoutParams dividerParams;
    private int dividerColor;

    //默认底部高度
    private int mDefaultBottomHeight;
    //
    private FragmentManager mFragmentManager;
    private List<ZItemData> mViewDatas;
    private int currentIndex = -1;
    private ZCallback mCallback;

    public ZFlContainView(Context context) {
        super(context);
        init(context, null);
    }

    public ZFlContainView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZFlContainView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);
        mFlBtnGroup = new LinearLayout(context);
        mFlBtnGroup.setOrientation(HORIZONTAL);
        mFrameLayout = new FrameLayout(context);
        mFrameLayout.setId(ZConfig.flId);
        ZConfig.flId--;
        LinearLayout.LayoutParams bottomParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams frameParams = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
        frameParams.weight = 1;
        //
        mDefaultBottomHeight = DpUtil.dip2px(context, 50);
        //
        int loc = 1;
        float bottomHeight = mDefaultBottomHeight;
        if(attrs != null) {
            final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ZFlContainView, 0, 0);
            loc = array.getInt(R.styleable.ZFlContainView_loc, 1);
            bottomHeight = array.getDimension(R.styleable.ZFlContainView_bottomHeight, mDefaultBottomHeight);
            if(bottomHeight <= 0) {
                bottomHeight = mDefaultBottomHeight;
            }
            int bottomPadTop = array.getInt(R.styleable.ZFlContainView_bottomPadTop, 0);
            int bottomPadLeft = array.getInt(R.styleable.ZFlContainView_bottomPadLeft, 0);
            int bottomPadBottom = array.getInt(R.styleable.ZFlContainView_bottomPadBottom, 0);
            int bottomPadRight = array.getInt(R.styleable.ZFlContainView_bottomPadRight, 0);
            int bottomBackgroundColor = array.getColor(R.styleable.ZFlContainView_bottomBackgroundColor, -1);
            //
            boolean hasDivider = array.getBoolean(R.styleable.ZFlContainView_hasDivider, false);
            if(hasDivider) {
                dividerParams = new LayoutParams(1, ViewGroup.LayoutParams.MATCH_PARENT);
                dividerColor = array.getColor(R.styleable.ZFlContainView_dividerColor, Color.WHITE);
                dividerParams.width = array.getInt(R.styleable.ZFlContainView_dividerWidth, 1);
                int marginTAL = array.getInt(R.styleable.ZFlContainView_dividerMarginTopAndBottom, 0);
                dividerParams.topMargin = marginTAL;
                dividerParams.bottomMargin = marginTAL;
            }
            array.recycle();
            //
            mFlBtnGroup.setPadding(bottomPadLeft, bottomPadTop, bottomPadRight, bottomPadBottom);
            if(bottomBackgroundColor != -1) {
                mFlBtnGroup.setBackgroundColor(bottomBackgroundColor);
            }
        }
        bottomParams.height = (int) bottomHeight;
        if(loc == 1) {//底部
            addView(mFrameLayout, frameParams);
            addView(mFlBtnGroup, bottomParams);
        } else {//顶部
            addView(mFlBtnGroup, bottomParams);
            addView(mFrameLayout, frameParams);
        }
        //
        childParams = new LayoutParams(0, LayoutParams.MATCH_PARENT);
        childParams.weight = 1;
    }

    /**
     * @param fragmentManager：fragmentManager
     * @param firstFragment:第一个fragment
     * @param views：顶部的Views
     */
    public void setData(FragmentManager fragmentManager, Fragment firstFragment, List<IView> views) {
        if(mViewDatas != null || firstFragment == null) {
            Log.e(TAG, "firstFragment=null");
            return;
        }
        mFragmentManager = fragmentManager;
        if(views != null) {
            mViewDatas = new ArrayList<>();
            for(int i = 0; i < views.size(); i++) {
                ZItemData zItemData = new ZItemData();
                IView iView = views.get(i);
                iView.setChecked(false);
                zItemData.btnView = iView;
                ZBaseViewData data = iView.getViewData();
                childParams.weight = data.weight;
                childParams.topMargin = data.marginTop;
                childParams.leftMargin = data.marginLeft;
                childParams.bottomMargin = data.marginBottom;
                childParams.rightMargin = data.marginRight;
                childParams.gravity = data.gravity;
                //
                View view = iView.getView();
                if(view != null) {
                    final int position = i;
                    view.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mCallback != null) {
                                mCallback.onClick(position, mViewDatas.get(position));
                            }
                            showIndex(position);
                        }
                    });
                    if(i != 0 && dividerParams != null) {
                        View divider = new View(getContext());
                        divider.setBackgroundColor(dividerColor);
                        mFlBtnGroup.addView(divider, dividerParams);
                    }
                    mFlBtnGroup.addView(view, childParams);
                    mViewDatas.add(zItemData);
                }
                iView.initParams();
            }
            mViewDatas.get(0).fragment = firstFragment;
            showIndex(0);
        }
    }

    /**
     * @param fragmentManager：fragmentManager
     * @param zViewDatas:自定义view，viewData,fragment
     */
    private void setData(FragmentManager fragmentManager, final List<ZItemData> zViewDatas) {
        if(mViewDatas != null) {
            return;
        }
        mFragmentManager = fragmentManager;
        mViewDatas = zViewDatas;
        if(zViewDatas != null) {
            for(int i = 0; i < zViewDatas.size(); i++) {
                ZItemData zViewData = zViewDatas.get(i);
                IView iView = zViewData.btnView;
                iView.setChecked(false);
                //
                ZBaseViewData data = iView.getViewData();
                childParams.weight = data.weight;
                childParams.topMargin = data.marginTop;
                childParams.leftMargin = data.marginLeft;
                childParams.bottomMargin = data.marginBottom;
                childParams.rightMargin = data.marginRight;
                childParams.gravity = data.gravity;
                //
                View view = iView.getView();
                if(view != null) {
                    final int position = i;
                    view.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mCallback != null) {
                                mCallback.onClick(position, zViewDatas.get(position));
                            }
                            showIndex(position);
                        }
                    });
                    if(i != 0 && dividerParams != null) {
                        View divider = new View(getContext());
                        divider.setBackgroundColor(dividerColor);
                        mFlBtnGroup.addView(divider, dividerParams);
                    }
                    mFlBtnGroup.addView(view, childParams);
                }
                iView.initParams();
            }
            showIndex(0);
        }
    }

    /**
     * 显示fragment
     *
     * @param index:显示下标
     */
    private void showIndex(int index) {
        if(mViewDatas == null || mViewDatas.size() == 0 || index < 0) {
            return;
        }
        if(currentIndex == index) {
            return;
        }
        FragmentTransaction beginTransaction = mFragmentManager.beginTransaction();
        if(index < mViewDatas.size()) {
            ZItemData zViewData = mViewDatas.get(index);
            zViewData.btnView.setChecked(true);
            if(zViewData.fragment != null) {
                if(!zViewData.isAdd) {
                    beginTransaction.add(mFrameLayout.getId(), zViewData.fragment);
                    zViewData.isAdd = true;
                }
                beginTransaction.show(zViewData.fragment);
            }
        }
        if(currentIndex != -1) {
            ZItemData zViewData2 = mViewDatas.get(currentIndex);
            zViewData2.btnView.setChecked(false);
            if(zViewData2.fragment != null) {
                beginTransaction.hide(zViewData2.fragment);
            }
        }
        beginTransaction.commit();
        currentIndex = index;
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
        if(mViewDatas != null) {
            for(int i = 0; i < mViewDatas.size(); i++) {
                ZItemData zViewData = mViewDatas.get(i);
                zViewData.btnView.getView().setOnClickListener(null);
                zViewData.fragment = null;
                zViewData.btnView = null;
            }
            mViewDatas.clear();
            mViewDatas = null;
        }
        if(mCallback != null) {
            mCallback = null;
        }
    }

    public void setCallback(ZCallback mCallback) {
        this.mCallback = mCallback;
    }
}
