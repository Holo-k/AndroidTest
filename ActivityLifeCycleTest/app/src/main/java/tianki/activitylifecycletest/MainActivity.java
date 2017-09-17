package tianki.activitylifecycletest;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String tempData=savedInstanceState.getString("data_key");
            Log.d(TAG,tempData);
        }
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        startNormalActivity.setOnClickListener(listener);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startDialogActivity.setOnClickListener(listener);



    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            switch (btn.getId()) {
                case R.id.start_normal_activity: {
                    Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                    startActivity(intent);
                }

                case R.id.start_dialog_activity: {
                    Intent intent = new Intent(MainActivity.this, DailogActivity.class);

                    startActivity(intent);
                }
            }
        }
    };


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Poi  Poi";
        outState.putString("data_key", tempData);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestory");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
