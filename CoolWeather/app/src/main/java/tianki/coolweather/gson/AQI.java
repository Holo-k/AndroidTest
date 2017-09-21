package tianki.coolweather.gson;

/**
 * Created by Tiank on 9/21/2017.
 */

public class AQI {
    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
