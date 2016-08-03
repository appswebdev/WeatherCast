package college.edu.tomer.weathercast.wheather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by master on 03/08/16.
 */
public class HttpManager {
    public static String downloadUrl(String address) throws Exception {
        //Request a permission to use the internet:
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        InputStream in = con.getInputStream();
        //Readers can read a single byte
        InputStreamReader reader = new InputStreamReader(in);
        //Readers can read a single char
        BufferedReader bReader = new BufferedReader(reader);
        //Readers can read a single line as a String
        String line = bReader.readLine();
        StringBuilder builder = new StringBuilder();
        while (line != null) {
            builder.append(line);
            line = bReader.readLine();
        }
        return builder.toString();
    }
}
