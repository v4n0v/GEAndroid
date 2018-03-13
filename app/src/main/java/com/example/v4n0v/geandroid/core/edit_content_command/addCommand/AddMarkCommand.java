package com.example.v4n0v.geandroid.core.edit_content_command.addCommand;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class AddMarkCommand extends AddElementCommand{
    public AddMarkCommand(String answer) {
        super(answer, null
        );
    }

    @Override
    protected void prepareRequest() {
        request = new RequestBuilder().setMethod(Prefs.METHOD_GET)
                .setTarget(Prefs.TARGET_MARK)
                .setAction(Prefs.ACTION_INSERT)
                .setRequest("mark", answer)
                .build();
    }
}
