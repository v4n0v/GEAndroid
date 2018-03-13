package com.example.v4n0v.geandroid.core.get_command;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.GenerationObj;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class GetGlassTableCommand extends ObservedCommand{
    public GetGlassTableCommand(BaseObject inputObject) {
        super(inputObject);
    }




    @Override
    public void buildRequest() {
        GenerationObj car = (GenerationObj) inputObject;
        request = new RequestBuilder().setMethod(Prefs.METHOD_POST)
                .setAction(Prefs.ACTION_SELECT)
                .setTarget(Prefs.TARGET_TABLE_GOODS)
                .setRequest("car", String.valueOf(car.getId()))
                .build();
    }

//    @Override
  //  void fillObject(int i) {
//        GlassObject tblRow = (GlassObject) components.get(i);
//    }
}
