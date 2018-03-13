package com.example.v4n0v.geandroid;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by v4n0v on 13.03.18.
 */

public class Order {
    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    long date;
    float summ;

    public Order(float summ) {

        this.date = System.currentTimeMillis();
        this.summ = summ;
    }
}
