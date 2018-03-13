package com.example.v4n0v.geandroid.core.edit_content_command.addCommand;


import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.GlassObject;
import com.example.v4n0v.geandroid.core.request_builder.RequestBuilder;

public class AddGlassCommand extends AddElementCommand{
    public AddGlassCommand(BaseObject baseObject) {
        super(null, baseObject);
    }

    @Override
    protected void prepareRequest() {

        GlassObject glass = (GlassObject) baseObject;
        request=new RequestBuilder().setMethod(Prefs.METHOD_GET)
                .setTarget(Prefs.TARGET_GLASS)
                .setAction(Prefs.ACTION_INSERT)
                .setRequest("id_car", String.valueOf(glass.getCarId()))
                .setRequest("id_glass_type", String.valueOf(glass.getGlassTypeId()))
                .setRequest("id_glass_opt", String.valueOf(glass.getGlassOptionId()))
                .setRequest("glass_description", glass.getDescription())
                .setRequest("price_in", String.valueOf(glass.getPriceIn()))
                .setRequest("price_out", String.valueOf(glass.getPrice()))
                .setRequest("alert_remainder", String.valueOf(glass.getAlert()))
                .setRequest("glass_factory", String.valueOf(glass.getGlassFactory()))
                .setRequest("insert_method", String.valueOf(glass.getInsertMethod()))
                .setRequest("insert_price", String.valueOf(glass.getInsertPrice()))
                .setRequest("body_type", String.valueOf(glass.getBodyTypeId()))
                .setRequest("optListString", glass.getOptListString())
                .build();
    }
}


