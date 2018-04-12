package com.example.v4n0v.geandroid.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by avetc on 11.04.2018.
 */

public abstract class Entity{

    protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public String getObjectClass() {
        return objectClass;
    }

    String objectClass;

    public Entity(String objectClass) {
        this.objectClass = objectClass;
        obj1 = new JsonObject();
        // серверынй метод, возвращает JSON
    }

    protected JsonObject obj1;
    // серверынй метод, возвращает JSON

    // клиентский метод, возвращает запрос

    abstract public JsonElement toJSONObject();
}


