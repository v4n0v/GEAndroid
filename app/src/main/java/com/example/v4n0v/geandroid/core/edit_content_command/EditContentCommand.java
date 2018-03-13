package com.example.v4n0v.geandroid.core.edit_content_command;


import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.Composite;
import com.example.v4n0v.geandroid.core.request_builder.MyRequest;
import com.example.v4n0v.geandroid.core.request_builder.RequestController;

import java.util.List;

public abstract class EditContentCommand {
    protected MyRequest request;

    public EditContentCommand() {

        prepareRequest();
    }

    protected abstract void prepareRequest();



    public boolean isOk(String answer) {

        Composite serverObject = (Composite) RequestController.responseToObject(RequestController.recieveResponse(request));
        if (serverObject != null) {
            List<BaseObject> components = serverObject.getComponents();
            if (components.get(0).getObjectClass().equals("ok")){
                return true;
            }
        }
        return false;
    }


}
