package com.example.v4n0v.geandroid.core;

import com.example.v4n0v.geandroid.core.get_command.GetBodyTypeCommand;
import com.example.v4n0v.geandroid.core.get_command.GetGenerationCommand;
import com.example.v4n0v.geandroid.core.get_command.GetGlassFactoryCommand;
import com.example.v4n0v.geandroid.core.get_command.GetGlassOptionList;
import com.example.v4n0v.geandroid.core.get_command.GetGlassTableCommand;
import com.example.v4n0v.geandroid.core.get_command.GetGlassTypeCommand;
import com.example.v4n0v.geandroid.core.get_command.GetInsertClassCommand;
import com.example.v4n0v.geandroid.core.get_command.GetMarksCommand;
import com.example.v4n0v.geandroid.core.get_command.GetModelsCommand;
import com.example.v4n0v.geandroid.core.get_command.ObservedCommand;
import com.example.v4n0v.geandroid.core.get_command.adapter.BaseObjectAdapter;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.GenerationObj;
import com.example.v4n0v.geandroid.core.objects.GlassObject;
import com.example.v4n0v.geandroid.core.objects.IdTitleObj;
import com.example.v4n0v.geandroid.core.objects.InsertClass;

import java.util.List;


public class GetListOperator  {

    private ObservedCommand command;
 //   MyRequest request;

    BaseObjectAdapter objectAdapter = new BaseObjectAdapter();


    public List<BaseObject> getComponents() {
        return command.getComponents();
    }

//    @Override
//    public ObservableList<String> getMarks(BaseObject object) {
//        command = new GetMarksCommand(object);
//
//        //return command.returnRecievedList();
//        return objectAdapter.returnStringList(command.returnRecievedList());
//    }

    public List<IdTitleObj> getGlassTypes( ) {
        command = new GetGlassTypeCommand(null);

        return objectAdapter.baseObjToIdTitleObj(command.returnRecievedList());
//        return objectAdapter.returnStringList(command.returnRecievedList());
    }

//    @Override
//    public ObservableList<String> getModels(BaseObject object) {
//
//        command = new GetModelsCommand(object);
//        return objectAdapter.returnStringList(command.returnRecievedList());
//    }
    public List<IdTitleObj> getModels(BaseObject object) {

        command = new GetModelsCommand(object);
        return objectAdapter.baseObjToIdTitleObj(command.returnRecievedList());
    }


    public List<IdTitleObj> getMarks() {
        command = new GetMarksCommand(null);
        return objectAdapter.baseObjToIdTitleObj(command.returnRecievedList());
    }

    public List<GenerationObj> getGenerations(BaseObject object) {

        command = new GetGenerationCommand(object);
        return  objectAdapter.returnGenerationList(command.returnRecievedList());
    }




    public List<IdTitleObj> getBodyTypes() {
        command = new GetBodyTypeCommand(null);
        return objectAdapter.baseObjToIdTitleObj(command.returnRecievedList());
//        return objectAdapter.returnStringList(command.returnRecievedList());
    }

    public List<IdTitleObj> getGlassOptions() {
        command = new GetGlassOptionList(null);
        return objectAdapter.baseObjToIdTitleObj(command.returnRecievedList());
//        return objectAdapter.returnStringList(command.returnRecievedList());
    }

    public List<IdTitleObj> getGlassFactory() {
        command = new GetGlassFactoryCommand(null);
        return objectAdapter.baseObjToIdTitleObj(command.returnRecievedList());
//        return objectAdapter.returnStringList(command.returnRecievedList());
    }
    public List<InsertClass> getInsertClass() {
        command = new GetInsertClassCommand(null);
//        return objectAdapter.baseObjToIdTitleObj(command.returnRecievedList());
        return objectAdapter.returnInsertClassList(command.returnRecievedList());
//        return objectAdapter.returnStringList(command.returnRecievedList());
    }

}
