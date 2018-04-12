package com.example.v4n0v.geandroid.models;

import com.example.v4n0v.geandroid.entities.IdTitleObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


public class SelectCarModel<K,V> {
    List<IdTitleObj> marks;
    List<IdTitleObj> models;
    List<IdTitleObj> generations;



    HashMap<Integer, String> mark;
    HashMap<Integer, String> model;
    HashMap<Integer, String> generation;

    public SelectCarModel() {
        this.marks = new ArrayList<>();
        this.models = new ArrayList<>();
        this.generations = new ArrayList<>();
    }


//    public static <K, V> Optional<K> findKey(Map<K, V> map, V value) {
//        return map.entrySet().stream()
//                .filter(entry -> entry.getValue().equals(value))
//                .findAny();
//    }

    public static int getKey(HashMap<Integer, String> records, String title){
        Set<Map.Entry<Integer, String>> entSet = records.entrySet();
        for (Map.Entry<Integer, String> pair : entSet) {
            if (title.equals(pair.getValue())) {
                return pair.getKey();
            }
        }
        return -1;
    }

    public HashMap<Integer, String> getMark() {
        return mark;
    }

    public void setMark(HashMap<Integer, String> mark) {
        this.mark = mark;
    }

    public void setMarksList(List<IdTitleObj> marks) {
        this.marks = marks;
    }

    public void getIdByPosition(int pos) {
        marks.get(pos);
    }

    public void addMarkElement(int id, String title) {
        marks.add(new IdTitleObj(id, title));
    }

    public void removeMarkElement(IdTitleObj element) {
        marks.remove(element);
    }

    public List<IdTitleObj> getMarksList() {
        return marks;
    }

    public int getCount() {
        return marks.size();
    }
}
