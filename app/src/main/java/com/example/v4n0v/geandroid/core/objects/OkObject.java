package com.example.v4n0v.geandroid.core.objects;

import com.google.gson.JsonElement;

public class OkObject extends BaseObject{
    public OkObject() {
        super("ok");
    }

    @Override
    public JsonElement toJSONObject() {
        obj1.addProperty("objClass", objectClass);
        return obj1;
    }
}
