package com.example.v4n0v.geandroid.goods;

/**
 * Created by v4n0v on 16.03.18.
 */

public class Product {
    boolean isSelected;
    int id;
    String title;
    float  price;

    public Product(int id, String title, float price) {
        this.id = id;
        this.title = title;
        this.price = price;
        isSelected=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }



    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
