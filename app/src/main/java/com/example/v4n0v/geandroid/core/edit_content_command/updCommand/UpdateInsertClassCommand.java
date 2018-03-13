package com.example.v4n0v.geandroid.core.edit_content_command.updCommand;

import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class UpdateInsertClassCommand extends UpdateElementCommand {

    private int autoId;


    public UpdateInsertClassCommand(int id, int autoId) {
       super(id);
        this.autoId = autoId;
    }


    @Override
    void prepareRequest() {
        request = new RequestBuilder()
                .setMethod(Prefs.METHOD_POST)
                .setTarget(Prefs.TARGET_INSERT_CLASS)
                .setAction(Prefs.ACTION_UPD)
                .setRequest("id", String.valueOf(id))
                .setRequest("autoId", String.valueOf(autoId))
                .build();
        System.out.println(request);
    }
}
