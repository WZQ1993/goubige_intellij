package com.wangziqing.goubige.model;

/**
 * Created by WZQ_PC on 2016/5/23 0023.
 */
public class Mall {
    private int ID;
    private String name;
    private int goods_from;
    private String img;
    private int img_w;
    private int img_h;

    public int getMall_id() {
        return mall_id;
    }

    public void setMall_id(int mall_id) {
        this.mall_id = mall_id;
    }

    private int mall_id;
    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public int getImg_h() {
        return img_h;
    }

    public void setImg_h(int img_h) {
        this.img_h = img_h;
    }

    public int getImg_w() {
        return img_w;
    }

    public void setImg_w(int img_w) {
        this.img_w = img_w;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getGoods_from() {
        return goods_from;
    }

    public void setGoods_from(int goods_from) {
        this.goods_from = goods_from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int order_num;

    @Override
    public String toString() {
        return "Mall{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", goods_from=" + goods_from +
                ", img='" + img + '\'' +
                ", img_w=" + img_w +
                ", img_h=" + img_h +
                ", order_num=" + order_num +
                '}';
    }
}
