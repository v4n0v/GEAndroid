package com.example.v4n0v.geandroid.core.get_command;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.IdTitleObj;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class GetModelsCommand extends IDTitleObsevedCommand{
    public GetModelsCommand(BaseObject object) {
        super(object);
    }

    @Override
    public void buildRequest() {
        IdTitleObj car = (IdTitleObj) inputObject;
        request = new RequestBuilder().setMethod(Prefs.METHOD_GET)
                .setAction(Prefs.ACTION_SELECT)
                .setTarget(Prefs.TARGET_MODEL)
                .setRequest("mark", String.valueOf(car.getId()))
                .build();
    }
}
