package tianki.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Tiank on 9/11/2017.
 */

public class MyDatavaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_BOOK = "create table Book (" + "id integer primary key autoincrement,"
            + "author text" + "price real,"
            + "pages integer,"
            + "name text)";


    private static final String CREATE_CATEGORY="create table Category ("
            +" id integer primary key autoincrement ,"
            +" category_name text ,"
            +" category_code integer)";

    private Context context;

    public MyDatavaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int verson) {
        super(context, name, factory, verson);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists Category");
        onCreate(sqLiteDatabase);
    }
}
