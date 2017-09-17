package tianki.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Tiank on 9/16/2017.
 */

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "Thread id is : "+Thread.currentThread().getId());

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestory executed");
    }
}
