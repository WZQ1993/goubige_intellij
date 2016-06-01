package com.wangziqing.goubige.model;

import java.sql.Timestamp;

/**
 * Created by WZQ_PC on 2016/5/27 0027.
 */
public class Fans {
    private int ID;
    private int userID;
    private int fansID;
    private Timestamp creatTime;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFansID() {
        return fansID;
    }

    public void setFansID(int fansID) {
        this.fansID = fansID;
    }

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Fans{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", fansID=" + fansID +
                ", creatTime=" + creatTime +
                '}';
    }
}
