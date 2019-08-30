package com.zyc.sw.fragment.base;

import android.view.Gravity;

public class ZBaseViewData {
    public int weight = 1;
    public int marginLeft;
    public int marginTop;
    public int marginRight;
    public int marginBottom;
    public int gravity = Gravity.CENTER;

    protected ZBaseViewData() {

    }

    public static class Builder {
        private ZBaseViewData zBaseViewData;

        public Builder() {
            zBaseViewData = new ZBaseViewData();
        }

        public Builder setWeight(int weight) {
            zBaseViewData.weight = weight;
            return this;
        }

        public Builder setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
            zBaseViewData.marginLeft = marginLeft;
            zBaseViewData.marginTop = marginTop;
            zBaseViewData.marginRight = marginRight;
            zBaseViewData.marginBottom = marginBottom;
            return this;
        }

        public Builder setGravity(int gravity) {
            zBaseViewData.gravity = gravity;
            return this;
        }


        public ZBaseViewData build() {
            return zBaseViewData;
        }
    }
}
