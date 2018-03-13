package com.example.v4n0v.geandroid.core.get_command;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class GetGlassOptionList extends IDTitleObsevedCommand{
    public GetGlassOptionList(BaseObject object) {
        super(object);
    }

    @Override
    public void buildRequest() {
        request = new RequestBuilder().setMethod(Prefs.METHOD_POST)
                .setAction(Prefs.ACTION_SELECT)
                .setTarget(Prefs.TARGET_GLASS_OPTION)
                .setBlankRequest()
                .build();
    }
}
