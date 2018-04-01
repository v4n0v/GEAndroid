package com.example.v4n0v.geandroid.models;

import java.util.ArrayList;
import java.util.List;


public class SelectCarModel {
    List<String> marks;
    List<String> models;
    List<String> generations;


    public SelectCarModel( ) {
        this.marks = new ArrayList<>();
        this.models = new ArrayList<>();
        this.generations = new ArrayList<>();
    }


    public void setMarksList(List<String> marks){
        this.marks=marks;
    }

     public void getIdByPosition(int pos) {
         marks.get(pos);
     }
    public void addMarkElement(String element) {
        marks.add(element);
    }
    public void removeMarkElement(String element) {
        marks.add(element);
    }

    public List<String> getMarksList() {
        return marks;
    }
}
