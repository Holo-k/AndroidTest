package tianki.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SecondAcitivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Log.d("SecondActivity", this.toString());
        Log.d("SecondActivity", "Task id is" + getTaskId());
        setContentView(R.layout.second_layout);

        /*Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("SecondACtivity",data);*/


        Button button = (Button) findViewById(R.id.button_2);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("data_return","Poi Poi  Poi");
                setResult(RESULT_OK,intent);
                finish();
            }
        });*/



        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondAcitivity.this, FirstActivity.class);
                startActivity(intent);

            }
        });*/


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondAcitivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestory");
    }

    public static <T> void test(Class<T> cls){
        Object obj;
        Type sType = cls.getClass().getGenericSuperclass();
        Type[] generics = ((ParameterizedType) sType).getActualTypeArguments();
        Class<T> mTClass = (Class<T>) (generics[0]);
        try {
            obj= mTClass.newInstance();

        }
        catch (Exception e){

        }

    }

    public static <T> void actionStart(Context context, String data1, String data2, Class<T> cls) {




        Intent intent = new Intent(context, SecondAcitivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("parma2", data2);
        context.startActivity(intent);
    }
}
