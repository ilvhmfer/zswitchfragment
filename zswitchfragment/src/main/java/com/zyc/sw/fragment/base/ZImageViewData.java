package com.zyc.sw.fragment.base;

public class ZImageViewData extends ZBaseViewData {
    public int normalResId;
    public int selectResId;
    public int normalBackgroundId;
    public int selectBackgroundId;
    public int imageWidth;
    public int imageHeight;

    protected ZImageViewData() {
        super();
    }

    public static class Builder {
        private ZImageViewData zBaseViewData;

        public Builder() {
            zBaseViewData = new ZImageTextData();
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

        public Builder setImageBitmapResourceId(int normalResId, int selectResId) {
            zBaseViewData.normalResId = normalResId;
            zBaseViewData.selectResId = selectResId;
            return this;
        }

        public Builder setBackgroundResourceId(int normalBackgroundId, int selectBackgroundId) {
            zBaseViewData.normalBackgroundId = normalBackgroundId;
            zBaseViewData.selectBackgroundId = selectBackgroundId;
            return this;
        }

        public Builder setSize(int imageWidth, int imageHeight) {
            zBaseViewData.imageWidth = imageWidth;
            zBaseViewData.imageHeight = imageHeight;
            return this;
        }


        public ZImageViewData build() {
            return zBaseViewData;
        }
    }
}
