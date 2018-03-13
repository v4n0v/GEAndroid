package com.example.v4n0v.geandroid.core.edit_content_command.addCommand;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.IdTitleObj;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class AddModelCommand extends AddElementCommand{

    public AddModelCommand(String answer, BaseObject baseObject) {
        super(answer, baseObject);


    }
    @Override
    protected void prepareRequest(){
       // Car car = (Car) baseObject;
        IdTitleObj car = (IdTitleObj) baseObject;
        request=new RequestBuilder().setMethod(Prefs.METHOD_GET)
                .setTarget(Prefs.TARGET_MODEL)
                .setAction(Prefs.ACTION_INSERT)
                .setRequest("mark", car.getTitle())
                .setRequest("model", answer)
                .build();
    }
}
