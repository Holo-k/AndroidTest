package tianki.coolweather;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.IntDef;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import tianki.coolweather.gson.Weather;
import tianki.coolweather.util.HttpUtil;
import tianki.coolweather.util.Utility;

public class AutoUpdateService extends Service {
    public AutoUpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return  null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        updateWeather();
        updateBingPic();
        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        int anhour=8*60*60*1000;
        long triggerAtTime= SystemClock.elapsedRealtime()+anhour;
        Intent i=new Intent(this,AutoUpdateService.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,i,0);
        alarmManager.cancel(pendingIntent);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pendingIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    private  void updateWeather(){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString=sharedPreferences.getString("weather",null);
        if (weatherString!=null){
            Weather weather= Utility.hadleWeatherResponse(weatherString);
            String weatherId=weather.basic.weatherId;

            String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId + "&key=bc0418b57b2d4918819d3974ac1285d9";
            HttpUtil.sendOKHttpRequest(weatherUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseText=response.body().string();
                    Weather weather=Utility.hadleWeatherResponse(responseText);
                    if (weather!=null&&"ok".equals(weather.status)){
                        SharedPreferences.Editor edit=PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                        edit.putString("weather",responseText);
                        edit.apply();
                    }

                }
            });
        }
    }

    private void updateBingPic(){
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOKHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bingPic=response.body().string();
                SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                editor.putString("bing_pic",bingPic);
                editor.apply();

            }
        });
    }
}
