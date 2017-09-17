package tianki.databasetest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDatavaseHelper myDatavaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatavaseHelper = new MyDatavaseHelper(this, "BookStore.db", null, 2);
        Button btnCreate = (Button) findViewById(R.id.create_database);
        Button btnAddData = (Button) findViewById(R.id.add_data);
        Button btnUpdateData = (Button) findViewById(R.id.update_data);
        btnCreate.setOnClickListener(listener);
        btnAddData.setOnClickListener(listener);
        btnUpdateData.setOnClickListener(listener);


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn=(Button)view;
            switch (btn.getId()) {
                case R.id.create_database: {
                    myDatavaseHelper.getWritableDatabase();

                    Toast.makeText(MainActivity.this, "Create", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.add_data: {
                    SQLiteDatabase sqLiteDatabase = myDatavaseHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("name", "The Da Vinci Code");
                    values.put("author", "Dan Brown");
                    values.put("pages", 544);
                    values.put("price", 15.6);
                    sqLiteDatabase.insert("Book", null, values);
                    values.clear();
                    values.put("name", "The Lost Symbol");
                    values.put("author", "Dan Brown");
                    values.put("pages", 510);
                    values.put("price", 19.6);
                    sqLiteDatabase.insert("Book", null, values);
                    Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_SHORT).show();
                    break;
                }

                case R.id.update_data: {
                    SQLiteDatabase sqLiteDatabase = myDatavaseHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("price", 10.99);
                    sqLiteDatabase.update("Book", values,"name= ? ", new String[]{"The Da Vinci Code"});
                    Toast.makeText(MainActivity.this, "Update", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    };
}
