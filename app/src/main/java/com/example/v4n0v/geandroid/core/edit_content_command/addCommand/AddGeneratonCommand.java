package com.example.v4n0v.geandroid.core.edit_content_command.addCommand;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.IdTitleObj;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class AddGeneratonCommand extends AddElementCommand {
    public AddGeneratonCommand(String generation, BaseObject baseObject) {
        super(generation, baseObject);
    }

    @Override
    protected void prepareRequest() {
        answer = answer.replace(" ", "");
        String[] gen = answer.split("-");
        IdTitleObj car = (IdTitleObj) baseObject;
        request = new RequestBuilder().setMethod(Prefs.METHOD_POST)
                .setTarget(Prefs.TARGET_GENERATION)
                .setAction(Prefs.ACTION_INSERT)
                //   .setRequest("mark", car.getMark())
                .setRequest("model", String.valueOf(car.getId()))
                .setRequest("yearFrom", gen[0])
                .setRequest("yearTo", gen[1])
                .build();
    }
}
