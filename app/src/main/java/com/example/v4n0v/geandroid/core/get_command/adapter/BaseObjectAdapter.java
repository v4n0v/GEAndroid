package com.example.v4n0v.geandroid.core.get_command.adapter;


import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.GenerationObj;
import com.example.v4n0v.geandroid.core.objects.GlassObject;
import com.example.v4n0v.geandroid.core.objects.IdTitleObj;
import com.example.v4n0v.geandroid.core.objects.InsertClass;

import com.example.v4n0v.geandroid.core.objects.*;

import java.util.ArrayList;
import java.util.List;

public class BaseObjectAdapter {




    public static  List<IdTitleObj> baseObjToIdTitleObj(List<BaseObject> inputList) {
        if (inputList != null) {
            List<IdTitleObj> resultList = new ArrayList<>();
            for (int i = 0; i < inputList.size(); i++) {
                IdTitleObj obj = (IdTitleObj) inputList.get(i);

                resultList.add(obj);
            }
            return resultList;
        }
        return null;
    }


    public static List<GenerationObj> returnGenerationList(List<BaseObject> inputList) {

        if (inputList != null) {
            List<GenerationObj> resultList = new ArrayList<>();
            for (int i = 0; i < inputList.size(); i++) {
                GenerationObj car = (GenerationObj) inputList.get(i);
                //currentModelGenerations.add(cars);
                resultList.add(car);

            }
            return resultList;
        }
        return null;
    }

    public static List<InsertClass> returnInsertClassList(List<BaseObject> inputList) {

        if (inputList != null) {
            List<InsertClass> resultList = new ArrayList<>();
            for (int i = 0; i < inputList.size(); i++) {
                InsertClass row = (InsertClass) inputList.get(i);
                // row.setGlassFactoryTitle(getTitleById(mainController.getDataMap().getGlassFactoryList(), row.getGlassFactory()));

                //currentModelGenerations.add(cars);
                resultList.add(row);

            }
            return resultList;

        }
        return null;

    }


    public static String getTitleById(List<IdTitleObj> objs, int id) {
        for (int i = 0; i < objs.size(); i++) {
            if (objs.get(i).getId() == id) {
                return objs.get(i).getTitle();
            }
        }
        return null;
    }

}
