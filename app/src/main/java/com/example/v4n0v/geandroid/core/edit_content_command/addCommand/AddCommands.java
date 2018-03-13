package com.example.v4n0v.geandroid.core.edit_content_command.addCommand;


import com.example.v4n0v.geandroid.core.objects.BaseObject;

public interface AddCommands {
    boolean addModelIsComplete(String model, BaseObject baseObject);
    boolean addMarkIsComplete(String mark);
    boolean addGenerationIsComplete(String generation, BaseObject baseObject);
}
