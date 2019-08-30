package com.zyc.sw.fragment.base;

public class ZImageTextData extends ZImageViewData {
    public int normalTextColor;
    public int selectTextColor;
    public int drawPadding;
    public int textSize;
    public String text;

    protected ZImageTextData() {
        super();
    }

    public static class Builder {
        private ZImageTextData zBaseViewData;

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


        public Builder setText(String text) {
            zBaseViewData.text = text;
            return this;
        }

        public Builder setTextSize(int textSize) {
            zBaseViewData.textSize = textSize;
            return this;
        }

        public Builder setDrawPadding(int drawPadding) {
            zBaseViewData.drawPadding = drawPadding;
            return this;
        }

        public Builder setTextColor(int normalTextColor, int selectTextColor) {
            zBaseViewData.normalTextColor = normalTextColor;
            zBaseViewData.selectTextColor = selectTextColor;
            return this;
        }


        public ZImageTextData build() {
            return zBaseViewData;
        }
    }
}
