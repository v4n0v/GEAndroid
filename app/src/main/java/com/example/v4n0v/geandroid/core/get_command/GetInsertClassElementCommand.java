package com.example.v4n0v.geandroid.core.get_command;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class GetInsertClassElementCommand extends ObservedCommand {


    public GetInsertClassElementCommand(BaseObject inputObject) {
        super(inputObject);
    }

    @Override
    public void buildRequest() {


            request = new RequestBuilder().setMethod(Prefs.METHOD_POST)
                    .setAction(Prefs.ACTION_SELECT)
                    .setTarget(Prefs.TARGET_INSERT_CLASS_ELEMENT)
                    .setBlankRequest()
                    .build();
        }

//    @Override
//    void fillObject(int i) {
//
//    }

}
