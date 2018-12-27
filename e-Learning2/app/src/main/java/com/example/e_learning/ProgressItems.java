package com.example.e_learning;

/**
 * Created by INCBASHA on 12/26/2016.
 */

public class ProgressItems {

    private int imgId;
    private String title;
    private int progress;

    public ProgressItems(int imgId, String title, int progress) {
        this.imgId = imgId;
        this.title = title;
        this.progress = progress;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
