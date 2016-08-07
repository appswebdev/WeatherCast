package college.edu.tomer.weathercast;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
        holder.tvTime.setText(dataByPosition.getTimeStamp() + "");
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
