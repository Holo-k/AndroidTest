package tianki.filepersistencetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);
        String content=loadData();
        if (!(TextUtils.isEmpty(content))){
            editText.setText(content);
            editText.setSelection(content.length());
            Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = editText.getText().toString();
        saveData(inputText);
    }

    private void saveData(String inputText) {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = openFileOutput("data", MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(inputText);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    private String loadData() {
        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        StringBuilder stringBuilder=new StringBuilder();
        try{
            fileInputStream=openFileInput("data");
            bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally {
            try{
                bufferedReader.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }
}

