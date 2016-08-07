package college.edu.tomer.weathercast.wheather;

/**
 * Created by master on 03/08/16.
 */
public class WheatherData {
    private String temp;
    private String minTemp;
    private String description;
    private String imageID;
    private long timeStamp;

    public WheatherData(String temp, String maxTemp, String description, String imageID, long timeStamp) {
        this.temp = temp;
        this.minTemp = maxTemp;
        this.description = description;
        this.imageID = imageID;
        this.timeStamp = timeStamp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "WheatherData{" +
                "temp='" + temp + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", description='" + description + '\'' +
                ", imageID='" + imageID + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
