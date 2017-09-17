package tianki.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button snedNotice = (Button) findViewById(R.id.send_notice);
        snedNotice.setOnClickListener(listen);
    }

    View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.send_notice: {
                    Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.cancel(1);
                    Notification notification = new NotificationCompat.Builder(MainActivity.this).setContentTitle("This is content title")
                            .setContentText("This iscontent text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true)

//                            .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
//                            .setVibrate(new long[]{0,1000,100,1000})
//                            .setLights(Color.BLUE,1000,1000)


                            .setDefaults(NotificationCompat.DEFAULT_ALL)


//                            .setContentText("Happiness is not about being immortal nor having food " +
//                                    "or rights in one's hand. It’s about having each tiny wish come true, or having something to eat when you are hungry " +
//                                    "or having someone's love when you need love")


                            .setStyle(new android.support.v4.app.NotificationCompat.BigTextStyle().bigText("Happiness is not about being immortal nor having food or rights in one's hand. " +
                                    "It’s about having each tiny wish come true," +
                                    " or having something to eat when you are hungry " +
                                    "or having someone's love when you need love"))


                            .setStyle(new android.support.v4.app.NotificationCompat.BigPictureStyle()
                                    .bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.d)))

                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .build();


                    notificationManager.notify(1, notification);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    };
}
