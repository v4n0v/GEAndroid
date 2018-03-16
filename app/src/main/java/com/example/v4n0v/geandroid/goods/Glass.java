package com.example.v4n0v.geandroid.goods;

/**
 * Created by v4n0v on 13.03.18.
 */

public class Glass extends Product {

    private String factoryTitle;
    private float insertPrice;
    private String typeTitle;

    public Glass(int id, String title, String typeTitle, float price, float insertPrice) {
        super(id, title+" "+typeTitle, price);
        this.id=id;
        this.factoryTitle = title;
        this.price = price;
        this.insertPrice = insertPrice;
        this.typeTitle=typeTitle;
        this.isSelected = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;


    public String getFactoryTitle() {
        return factoryTitle;
    }

    public void setFactoryTitle(String factoryTitle) {
        this.factoryTitle = factoryTitle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getInsertPrice() {
        return insertPrice;
    }

    public void setInsertPrice(float insertPrice) {
        this.insertPrice = insertPrice;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }



    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

}
