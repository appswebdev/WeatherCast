package college.edu.tomer.weathercast;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import college.edu.tomer.weathercast.wheather.WheatherService;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        RecyclerView rvWeather =
                (RecyclerView) v.findViewById(R.id.weatherRecycler);

        new WheatherService(
                "Beersheva", rvWeather, getContext()
        ).execute();

        return v;
    }
}
