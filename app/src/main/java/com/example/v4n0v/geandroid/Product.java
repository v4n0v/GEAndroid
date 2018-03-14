package com.example.v4n0v.geandroid;

/**
 * Created by v4n0v on 13.03.18.
 */

public class Product extends Obj{
    public Product(String factoryTitle, String typeTitle, float price, float insertPrice) {
        this.factoryTitle = factoryTitle;
        this.price = price;
        this.insertPrice = insertPrice;
        this.typeTitle=typeTitle;
        this.isSelected = false;
    }

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

    private String factoryTitle;
    private float price;
    private float insertPrice;
    private boolean isSelected;

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    private String typeTitle;
}
