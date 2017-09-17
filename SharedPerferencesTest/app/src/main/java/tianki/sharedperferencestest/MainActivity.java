package tianki.sharedperferencestest;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView Name;
    TextView Age;
    TextView Married;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Button savaData = (Button) findViewById(R.id.save_data);
        savaData.setOnClickListener(listener);
        Button getData = (Button) findViewById(R.id.get_data);
        Name = (TextView) findViewById(R.id.Name);
        Age = (TextView) findViewById(R.id.Age);
        Married = (TextView) findViewById(R.id.Married);
        getData.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            switch (btn.getId()) {
                case R.id.save_data: {
                    editor.putString("Name", "Poi");
                    editor.putInt("Age", 21);
                    editor.putBoolean("Married", false);
                    editor.apply();
//                PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                }
                case R.id.get_data: {
                    String name = sharedPreferences.getString("Name", "");
                    int age = sharedPreferences.getInt("Age", 0);
                    boolean married = sharedPreferences.getBoolean("Married", false);
                    String isMarried = "";
                    if (married == true) {
                        isMarried = "已婚";
                    } else {
                        isMarried = "未婚";
                    }
                    Married.setText(isMarried);
                    Name.setText(name);
                    Age.setText(age);
                }
            }
        }
    };
}
