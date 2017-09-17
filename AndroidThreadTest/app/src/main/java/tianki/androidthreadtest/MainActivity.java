package tianki.androidthreadtest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    public static final int UPDARE_TEXT=1;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDARE_TEXT:{
                    text.setText(msg.obj.toString());
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        Button chageText = (Button) findViewById(R.id.change_text);
        chageText.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.change_text: {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
//                            Change("Poi");

                            Message message=new Message();
                            message.what=UPDARE_TEXT;
                            message.obj="Poi~~!!";
                            handler.sendMessage(message);
                        }
                    }).start();
                }
            }
        }
    };






    private void Change(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(msg);
            }
        });
    }
}
