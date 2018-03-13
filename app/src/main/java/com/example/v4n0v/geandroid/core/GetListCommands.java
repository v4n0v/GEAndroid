package com.example.v4n0v.geandroid.core;



import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.GenerationObj;
import com.example.v4n0v.geandroid.core.objects.IdTitleObj;

import java.util.List;

public interface GetListCommands {

    List<IdTitleObj> getMarks();

    List<IdTitleObj> getModels(BaseObject object);

    List<GenerationObj> getGenerations(BaseObject object);
   // ObservableList<IdTitleObj> getMarksIdTitle(BaseObject object);

}
