package JSONParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?APPID=5496614f4ca95e6dcc0445c1e7f3916d&q=Lviv");
        Scanner in = new Scanner(oracle.openStream());
        String inputLine = in.nextLine();
        JSONParser jp = new JSONParser();
        JSONObject jo = (JSONObject) jp.parse(inputLine);
        JSONArray weather = (JSONArray) jo.get("weather");
        JSONObject status = (JSONObject) weather.get(0);
        WeatherRetriever wr = new WeatherRetriever("Lviv");
        wr.printWeather();
    }
}