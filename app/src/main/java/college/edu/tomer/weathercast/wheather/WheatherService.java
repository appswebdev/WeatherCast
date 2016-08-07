package college.edu.tomer.weathercast.wheather;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import college.edu.tomer.weathercast.WeatherAdapter;

/**
 * Created by master on 03/08/16.
 */
public class WheatherService extends AsyncTask {

    String city;
    RecyclerView rvWeather;
    Context context;

    //Constructor
    public WheatherService(String city, RecyclerView rvWeather, Context context) {
        this.city = city;
        this.rvWeather = rvWeather;
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        //Code that runs in a background thread.
        String json = null;
        ArrayList<WheatherData> wheatherDataArrayList = new ArrayList<>();

        try {
            json = HttpManager.downloadUrl("http://api.openweathermap.org/data/2.5/forecast?mode=json&appid=fb69467683eea597ea58d93b606f2df6&units=metric&q=" + city + ",il");


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

        WeatherAdapter adapter = new WeatherAdapter(data, context);
        rvWeather.setAdapter(adapter);
        rvWeather.setLayoutManager(
                new LinearLayoutManager(context)
        );
    }
}
