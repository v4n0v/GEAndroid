package com.example.v4n0v.geandroid.core.get_command;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.IdTitleObj;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;


public class GetGenerationCommand extends ObservedCommand {
    public GetGenerationCommand(BaseObject object) {
        super(object);
    }

    @Override
    public void buildRequest() {
        if (inputObject!=null) {
            IdTitleObj car = (IdTitleObj) inputObject;
            request = new RequestBuilder().setMethod(Prefs.METHOD_POST)
                    .setAction(Prefs.ACTION_SELECT)
                    .setTarget(Prefs.TARGET_GENERATION)
                    // .setRequest("mark", markListView.getSelectionModel().getSelectedItem())
                    .setRequest("model", String.valueOf(car.getId()))
                    .build();
        } else {
            System.out.println("GetGenerationCommand inputObject = null!");
        }
    }

  //  @Override
//    void fillObject(int i) {
//        GenerationObj cars = (GenerationObj) components.get(i);
//        //currentModelGenerations.add(cars);
//        resultString.add((i+1)+". "+cars.toString());
    //}
}
