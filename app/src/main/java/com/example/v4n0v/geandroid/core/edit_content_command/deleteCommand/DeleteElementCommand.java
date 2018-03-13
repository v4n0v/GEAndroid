package com.example.v4n0v.geandroid.core.edit_content_command.deleteCommand;


import com.example.v4n0v.geandroid.core.request_builder.MyRequest;
import com.example.v4n0v.geandroid.core.request_builder.RequestController;

public abstract class DeleteElementCommand {
    MyRequest request;
    int id;


    public DeleteElementCommand(int id) {
        this.id = id;


    }

    abstract void prepareRequest();

    boolean deleteElement() {
        System.out.println("Готовим запрос");
        prepareRequest();
        System.out.println("Удаляем элемент "+request.getTarget());
        if (RequestController.isRequestAccepted(RequestController.recieveResponse(request)))
            return true;

        return false;

    }


}
