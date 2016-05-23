package com.wangziqing.goubige.model;

/**
 * Created by WZQ_PC on 2016/5/23 0023.
 */
public class Category {
    private int ID;
    private String title;

    public String getUrl_nicktitle() {
        return url_nicktitle;
    }

    public void setUrl_nicktitle(String url_nicktitle) {
        this.url_nicktitle = url_nicktitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String url_nicktitle;

    @Override
    public String toString() {
        return "Category{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", url_nicktitle='" + url_nicktitle + '\'' +
                '}';
    }
}
