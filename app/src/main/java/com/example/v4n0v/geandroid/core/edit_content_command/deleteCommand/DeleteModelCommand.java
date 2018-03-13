package com.example.v4n0v.geandroid.core.edit_content_command.deleteCommand;

import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class DeleteModelCommand extends DeleteElementCommand{
    public DeleteModelCommand(int id) {
        super(id);
    }

    @Override
    void prepareRequest() {
        request = new RequestBuilder()
                .setMethod(Prefs.METHOD_POST)
                .setTarget(Prefs.TARGET_MODEL)
                .setAction(Prefs.ACTION_DELETE)
                .setRequest("id", String.valueOf(id))
                .build();
    }
}
