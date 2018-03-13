package com.example.v4n0v.geandroid.core.request_builder;



//import com.example.v4n0v.geandroid.core.ConnectionManager;
import android.os.AsyncTask;

import com.example.v4n0v.geandroid.core.JsonController;

import com.example.v4n0v.geandroid.core.data.Prefs;
import com.example.v4n0v.geandroid.core.objects.BaseObject;
import com.example.v4n0v.geandroid.core.objects.Composite;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


// класс формирует и отправляет запросы
public class RequestController {
//    static URLConnection urlConnection;
    static JsonController jsonController;
//    static ConnectionManager connectionManager;
     String jsonResponse = null;

    public static String recieveResponse(MyRequest request) {
//     //   connectionManager = ConnectionManager.getInstance();
//       // connectionManager.setRequest(request.toString());
//        urlConnection = URLConnection.getInstance();
//

//        try {
//            String req=request.toString();
//            System.out.println(req);
//           // String req = URLEncoder.encode(request.toString(), "UTF-8");
//         //   jsonResponse = connectionManager.setRequest(req).getResp();
//            if (jsonResponse != null) {
//                if (!jsonResponse.equals(Prefs.ERROR_RESPONSE)) {
//                    return jsonResponse;
//                }
//            } else {
//
//                System.out.println("Это фиаско, братан!");
//
//            }
//        } catch (Exception e) {
//       //    AlertWindow.errorMessage("Ошибка соединения с сервером :(");
//        }
        try {

            OkHttpHandler httpHandler = new OkHttpHandler();
            httpHandler.execute(request);
      //      jsonResponse = urlConnection.receiveData(request);

//            if (jsonResponse != null) {
//                if (!jsonResponse.equals(Prefs.ERROR_RESPONSE)) {
//                    return jsonResponse;
//                }
//            } else {
//
//                System.out.println("Это фиаско, братан!");
//
//            }

        } catch (Exception e) {
            e.printStackTrace();
//            AlertWindow.errorMessage("Ошибка соединения с сервером :(");
        }

        return null;
    }

    public static BaseObject responseToObject(String jsonResponse) {
        jsonController = JsonController.getInstance();
        if (jsonResponse != null) {
            return jsonController.convertJsonToObject(jsonResponse);
        }
        return null;
    }

    public static boolean isRequestAccepted(String jsonResponse) {
        jsonController = JsonController.getInstance();
        Composite object = (Composite) jsonController.convertJsonToObject(jsonResponse);
        List<BaseObject> answers = object.getComponents();
        if (answers.get(0).getObjectClass().equals("ok")) {
            return true;
        } else


            return false;
    }

    public static class OkHttpHandler extends AsyncTask {

        OkHttpClient client = new OkHttpClient();


        protected void onPostExecute(String s) {
            super.onPostExecute(s);
         //   jsonResponse=s;
        }

        @Override
        protected String doInBackground(Object[] params) {
            Request.Builder builder = new Request.Builder();
            builder.url(String.valueOf(params[0]));
            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
