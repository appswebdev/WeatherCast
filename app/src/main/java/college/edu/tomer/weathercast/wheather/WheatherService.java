package college.edu.tomer.weathercast.wheather;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by master on 03/08/16.
 */
public class WheatherService extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        //Code that runs in a background thread.
        String json = null;
        ArrayList<WheatherData> wheatherDataArrayList = new ArrayList<>();

        try {
            json = HttpManager.downloadUrl("http://api.openweathermap.org/data/2.5/forecast?mode=json&appid=fb69467683eea597ea58d93b606f2df6&units=metric&q=beersheva,il");


            JSONObject jsonObject = new JSONObject(json);
            JSONArray list = jsonObject.getJSONArray("list");

            for (int i = 0; i < list.length(); i++) {
                JSONObject item = list.getJSONObject(i);
                long dt = item.getLong("dt");
                JSONObject main = item.getJSONObject("main");
                String temp = main.getString("temp");
                String tempMin = main.getString("temp_min");
                JSONObject weather = item.getJSONArray("weather").
                        getJSONObject(0);
                String description = weather.getString("main");
                String icon = weather.getString("icon");
                WheatherData data =
                        new WheatherData(
                                temp,
                                tempMin,
                                description,
                                icon,
                                dt
                        );
                wheatherDataArrayList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wheatherDataArrayList;
    }

    //The object is returned from doInBackground
    @Override
    protected void onPostExecute(Object o) {
        //Code that runs on the UI Thread
        System.out.println(o);
        ArrayList<WheatherData> data = (ArrayList<WheatherData>) o;

    }
}
