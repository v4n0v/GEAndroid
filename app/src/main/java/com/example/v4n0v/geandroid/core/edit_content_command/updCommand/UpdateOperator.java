package com.example.v4n0v.geandroid.core.edit_content_command.updCommand;

public class UpdateOperator {

    UpdateElementCommand comand;

    public boolean updAutoInsertClass(int idClass,int autoId) {
        comand=new UpdateInsertClassCommand(idClass, autoId);
        return comand.updateElement();
    }

}
