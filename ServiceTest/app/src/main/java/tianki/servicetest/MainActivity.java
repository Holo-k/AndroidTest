package tianki.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (MyService.DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService = (Button) findViewById(R.id.start_service);
        Button stopService = (Button) findViewById(R.id.stop_service);
        Button bindService = (Button) findViewById(R.id.bind_service);
        Button unbindService = (Button) findViewById(R.id.unbind_service);
        Button startIntentService = (Button) findViewById(R.id.start_intent_service);
        startService.setOnClickListener(listener);
        stopService.setOnClickListener(listener);
        bindService.setOnClickListener(listener);
        unbindService.setOnClickListener(listener);
        startIntentService.setOnClickListener(listener);
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start_service: {
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    startService(intent);
                    break;
                }
                case R.id.stop_service: {
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    startService(intent);
                    break;
                }
                case R.id.bind_service: {
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    bindService(intent, connection, BIND_AUTO_CREATE);
                    break;
                }

                case R.id.unbind_service: {
                    unbindService(connection);
                    break;
                }
                case R.id.start_intent_service: {
                    Log.d(TAG, "Thread id is : "+Thread.currentThread().getId());
                    Intent intent=new Intent(MainActivity.this,MyIntentService.class);
                    startService(intent);
                    break;
                }
            }
        }
    };
}
