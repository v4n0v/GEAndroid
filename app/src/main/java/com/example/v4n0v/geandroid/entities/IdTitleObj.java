package com.example.v4n0v.geandroid.entities;

import com.google.gson.JsonElement;


public class IdTitleObj extends Entity implements  Selectable {



    private int id;
    private String title;

    public int getId() {
        return id;
    }



    boolean isSelected;
    public IdTitleObj(int id, String title) {
        super("IdTitleObj");
        this.id = id;
        this.title = title;
    }


    public JsonElement toJSONObject() {
        obj1.addProperty("objectClass", objectClass);
        obj1.addProperty("id", id);
        obj1.addProperty("title", title);
        return obj1;
    }

    @Override
    public String toString() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setSelected(boolean value) {
        isSelected=value;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }
    public String getTitle() {
        return title;
    }
}
