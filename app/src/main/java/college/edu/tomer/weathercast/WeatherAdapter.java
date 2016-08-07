package college.edu.tomer.weathercast;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import college.edu.tomer.weathercast.wheather.WheatherData;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>{
    private final LayoutInflater inflater;
    ArrayList<WheatherData> weatherList;
    Context context;

    //Constructor:
    public WeatherAdapter(ArrayList<WheatherData> weatherList, Context context) {
        this.weatherList = weatherList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.wheather_item,
                parent, false);
        return new WeatherViewHolder(v);
    }
    public void onBindViewHolder(
            WeatherViewHolder holder, int position) {
        WheatherData dataByPosition = weatherList.get(position);
        //holder.ivWeather.setImageResource(dataByPosition.ge);
        holder.tvDescription.setText(dataByPosition.getDescription());
        holder.tvTemp.setText(dataByPosition.getTemp());
        holder.tvTempMin.setText(dataByPosition.getMinTemp());

        Date d = new Date(dataByPosition.getTimeStamp()*1000);
        holder.tvTime.setText(d.toString());

        int icon = R.drawable.icon_01d;

        switch (dataByPosition.getImageID()){
            case "01d":
                icon = R.drawable.icon_01d;
                break;
            case "01n":
                icon = R.drawable.icon_01n;
                break;

            case "02d":
                icon = R.drawable.icon_02d;
                break;
            case "02n":
                icon = R.drawable.icon_02n;
                break;

            case "03d":
                icon = R.drawable.icon_03d;
                break;
            case "03n":
                icon = R.drawable.icon_03n;
                break;

            case "04d":
                icon = R.drawable.icon_04d;
                break;
            case "04n":
                icon = R.drawable.icon_04n;
                break;

            case "09d":
                icon = R.drawable.icon_09d;
                break;
            case "09n":
                icon = R.drawable.icon_09n;
                break;

            case "10d":
                icon = R.drawable.icon_10d;
                break;
            case "10n":
                icon = R.drawable.icon_10n;
                break;

            case "11d":
                icon = R.drawable.icon_11d;
                break;
            case "11n":
                icon = R.drawable.icon_11n;
                break;

            case "13d":
                icon = R.drawable.icon_13d;
                break;
            case "13n":
                icon = R.drawable.icon_13n;
                break;

            case "50d":
                icon = R.drawable.icon_50d;
                break;
            case "50n":
                icon = R.drawable.icon_50n;
                break;
        }
        holder.ivWeather.setImageResource(icon);
    }
    public int getItemCount() {
        return weatherList.size();
    }
    //3.0 Create an inner class for the ViewHolder

    //findViewByID
    class WeatherViewHolder extends RecyclerView.ViewHolder{
        ImageView ivWeather;
        TextView tvDescription;
        TextView tvTime;
        TextView tvTempMin;
        TextView tvTemp;

        public WeatherViewHolder(View v) {
            super(v);
            //findViewByID
            ivWeather = (ImageView) v.findViewById(R.id.ivWeather);
            tvDescription = (TextView) v.findViewById(R.id.tvDescripn);
            tvTempMin = (TextView) v.findViewById(R.id.tvTempMin);
            tvTime = (TextView) v.findViewById(R.id.tvTime);
            tvTemp = (TextView) v.findViewById(R.id.tvTemp);
        }
    }
}
