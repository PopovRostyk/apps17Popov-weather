package JSONParser;

import java.io.IOException;
import java.util.*;

public class WeatherRetriever {
    private Retriever retriever;
    private String city;
    private final static String APPID = "5496614f4ca95e6dcc0445c1e7f3916d";

    public WeatherRetriever(String city) {
        this.city = city;
    }
    public void printWeather() throws IOException {
        HashMap <String, String> hashMap = new HashMap<String, String>();
        hashMap.put("APPID", APPID);
        hashMap.put("q", city);
        Retriever retriever = new Retriever("http://api.openweathermap.org/data/2.5/weather", hashMap);
        retriever.get();
    }
}
