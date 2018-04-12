package com.example.v4n0v.geandroid.utils;

import com.example.v4n0v.geandroid.entities.Composite;
import com.example.v4n0v.geandroid.entities.Entity;
import com.example.v4n0v.geandroid.entities.IdTitleObj;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by avetc on 12.04.2018.
 */

public class JsonController {

    private static final JsonParser parser = new JsonParser();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    static JsonController jsonController = new JsonController();

    private JsonController() {
    }

    public static JsonController getInstance() {
        return jsonController;
    }

    public Entity convertJsonToObject(String jsonResponse) {
        JsonObject jsonObj = (JsonObject) parser.parse(jsonResponse);

        Entity obj = parseJson(jsonObj);

//        if (ErrorObject.class.isInstance(obj)){
//            ErrorObject err = (ErrorObject) obj ;
//            AlertWindow.errorMessage(err.getObjectClass());
//            return null;
//        }
        return obj;

    }

    private String removeBrackets(String type) {
        // type=type.replace("\"", "");
        return type.replace("\"", "");
    }

    // реурсивное преобразование в объект
    public Entity parseJson(JsonObject jsonObj) {
        String objClass = removeBrackets(jsonObj.get("objectClass").toString());

        switch (objClass) {
            case "composite":
                JsonArray arr = jsonObj.getAsJsonArray("array");
                Composite composite = new Composite();
                for (int i = 0; i < arr.size(); i++) {
                    JsonObject arrayElement = (JsonObject) arr.get(i);
                    composite.addComponent(parseJson(arrayElement));
                }
                return composite;
            case "error":
//                    ErrorObject err = (ErrorObject)objectFabric(jsonObj);
//                    if (err!=null) {
//                        AlertWindow.errorMessage(err.getMessage());
//                    }
                return null;
            default:

                return objectFabric(jsonObj);
        }
    }




    public Entity objectFabric(JsonObject jsonObj) {
        String objClass = removeBrackets(jsonObj.get("objectClass").toString());

        switch (objClass) {
            case "IdTitleObj":
                //   ArrayList<String> marks = new ArrayList<>();
                return GSON.fromJson(jsonObj, IdTitleObj.class);
//                case "generation":
//                    return GSON.fromJson(jsonObj, GenerationObj.class);
//                case "tab_goods_in_stock":
//                    return GSON.fromJson(jsonObj, GlassObject.class);
//                case "insert_class":
//                    return GSON.fromJson(jsonObj, InsertClass.class);
//                case "insert_class_":
//                    return GSON.fromJson(jsonObj, InsertClassElement.class);
//                case "user":
//                    return GSON.fromJson(jsonObj, UserObject.class);
//                case "service":
//                    return GSON.fromJson(jsonObj, ServiceObject.class);
//                case "day":
//                    return GSON.fromJson(jsonObj, DateObject.class);
//                case "idObj":
//                    return GSON.fromJson(jsonObj, IdElement.class);
//                case "error":
//                    return GSON.fromJson(jsonObj, ErrorObject.class);
//                case "ok":
//                    return GSON.fromJson(jsonObj, OkObject.class);
            default:
                return null;

        }

    }


}
