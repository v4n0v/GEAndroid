package com.example.v4n0v.geandroid.goods;

/**
 * Created by v4n0v on 16.03.18.
 */

public class Service extends Product {
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    int time;
    public Service(int id, String title, float price, int time) {
        super(id, title, price);
        this.time=time;
    }
}
