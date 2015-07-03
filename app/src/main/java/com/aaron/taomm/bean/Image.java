package com.aaron.taomm.bean;

/**
 * Created by Aaron on 15/7/1.
 */
public class Image {

    private String url;
    private int thumbWidth;
    private int thumbHeight;

    public Image(String url, int width, int height) {
        this.url = url;
        this.thumbWidth = width;
        this.thumbHeight = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getThumbWidth() {
        return thumbWidth;
    }

    public void setThumbWidth(int thumbWidth) {
        this.thumbWidth = thumbWidth;
    }

    public int getThumbHeight() {
        return thumbHeight;
    }

    public void setThumbHeight(int thumbHeight) {
        this.thumbHeight = thumbHeight;
    }

}
