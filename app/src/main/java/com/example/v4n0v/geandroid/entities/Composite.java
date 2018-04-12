package com.example.v4n0v.geandroid.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Entity implements JsonObjectManager{
    public List<Entity> getComponents() {
        return components;
    }

    @SerializedName("array")
    @Expose
    private List<Entity> components = new ArrayList<>();

    public Composite( ) {
        super("composite");

    }

    public List<Entity> getArray() {
        return array;
    }

    public void setArray(List<Entity> array) {
        this.array = array;
    }

    List<Entity> array;

    String getComponentClass(){
        if (components.size()>0){
            return components.get(0).getClass().getSimpleName() ;
        }
        return null;
    }

    public void addComponent(Entity component){
        components.add(component);

    }
    public void removeComponent(Entity component){
        components.remove(component);
    }



    @Override
    public JsonElement toJSONObject() {
        JsonObject object = new JsonObject();
        object.addProperty("objectClass", objectClass);
        //object.addProperty("objClass", objectClass);
        JsonArray arr = new JsonArray();
        for (Entity component: components){
            arr.add( component.toJSONObject());
        }

        object.add("array", arr);
        return object;
    }
}