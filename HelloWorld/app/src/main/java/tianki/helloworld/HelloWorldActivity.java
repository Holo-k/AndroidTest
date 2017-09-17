package tianki.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Tiank on 9/3/2017.
 */

public class HelloWorldActivity extends BaseActivity
{
    private static final String TAG = "HelloWorldActivity";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_wayout);
        Log.d("HelloWorldActivity","OnCreateexecute");
    }
}
