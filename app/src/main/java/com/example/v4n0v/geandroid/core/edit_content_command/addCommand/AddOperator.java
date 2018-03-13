package com.example.v4n0v.geandroid.core.edit_content_command.addCommand;


import com.example.v4n0v.geandroid.core.objects.BaseObject;

public class AddOperator  implements AddCommands{
    AddElementCommand comand;


    @Override
    public boolean addModelIsComplete(String model, BaseObject baseObject) {
        comand=new AddModelCommand(model, baseObject);
        return comand.addElement(model);
    }

    @Override
    public boolean addMarkIsComplete(String mark) {
        comand=new AddMarkCommand(mark);
//        return comand.isOk(mark);
        return comand.addElement(mark);
    }

    @Override
    public boolean addGenerationIsComplete(String generation, BaseObject baseObject) {
        comand=new AddGeneratonCommand(generation, baseObject);
        return comand.addElement(generation);
    }

    public boolean addGlassIsComplete(BaseObject baseObject) {
        comand=new AddGlassCommand(baseObject);
        return comand.addElement(null);
    }
}
