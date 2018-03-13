package com.example.v4n0v.geandroid.core.get_command;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class GetBodyTypeCommand extends IDTitleObsevedCommand{
    public GetBodyTypeCommand(BaseObject object) {
        super(object);
    }

    @Override
    public void buildRequest() {
        request = new RequestBuilder().setMethod(Prefs.METHOD_POST)
                .setAction(Prefs.ACTION_SELECT)
                .setTarget(Prefs.TARGET_BODY_TYPE)
                .setBlankRequest()
                .build();
    }
}
