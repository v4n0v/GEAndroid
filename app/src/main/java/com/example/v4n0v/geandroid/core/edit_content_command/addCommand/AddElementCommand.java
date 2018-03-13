package com.example.v4n0v.geandroid.core.edit_content_command.addCommand;


import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.request_builder.MyRequest;
import com.example.v4n0v.geandroid.core.request_builder.RequestController;

public abstract class AddElementCommand {


    protected String answer;
    BaseObject baseObject;
    protected MyRequest request;


    public AddElementCommand(String answer, BaseObject baseObject) {
        this.baseObject=baseObject;
        this.answer = answer;
        prepareRequest();
    }

    protected abstract void prepareRequest();


    boolean addElement (String answer) {
        System.out.println("Добавляем модель");
        if (RequestController.isRequestAccepted(RequestController.recieveResponse(request)))
            return true;

        return false;

    }



}
