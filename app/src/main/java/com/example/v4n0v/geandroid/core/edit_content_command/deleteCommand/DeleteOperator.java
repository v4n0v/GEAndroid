package com.example.v4n0v.geandroid.core.edit_content_command.deleteCommand;

public class DeleteOperator {
    DeleteElementCommand comand;

    public boolean deleteGenerationIsComplete(int id) {
        comand=new DeleteGenerationCommand(id);
        return comand.deleteElement();
    }

    public boolean deleteModelIsComplete(int id) {
        comand=new DeleteModelCommand(id);
        return comand.deleteElement();
    }

    public boolean deleteMarkIsComplete(int id) {
        comand=new DeleteMarkCommand(id);
        return comand.deleteElement();
    }


    public boolean deleteGlassIsComplete(int id) {
        comand=new DeleteGlassCommand(id);
        return comand.deleteElement();
    }
}
