package com.example.v4n0v.geandroid.core.edit_content_command.updCommand;


import com.example.v4n0v.geandroid.core.request_builder.MyRequest;
import com.example.v4n0v.geandroid.core.request_builder.RequestController;

public abstract class UpdateElementCommand {
    MyRequest request;

    int id;

    public UpdateElementCommand(int id) {
        this.id = id;

    }

    abstract void prepareRequest();

    boolean updateElement() {
        //поготавливаем запрос
        prepareRequest();
        System.out.println("Обновляем элемент");
        if (RequestController.isRequestAccepted(RequestController.recieveResponse(request)))
            return true;
        return false;

    }


}