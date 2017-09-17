package tianki.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText _editText;
    private ImageView _imageView;
    private ProgressBar _progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button _button=(Button)findViewById(R.id.button);
        _editText=(EditText) findViewById(R.id.edit_text);
        _imageView=(ImageView)findViewById(R.id.image_view);
        _progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        _button.setOnClickListener(this);
        _imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _imageView.setImageResource(R.mipmap.a55644193_p0);

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: {
//                String data=_editText.getText().toString();
//                Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();

//                if (_progressBar.getVisibility()==View.GONE){
//                    _progressBar.setVisibility(View.VISIBLE);
//                }else{
//                    _progressBar.setVisibility(View.GONE);
//                }


//                int progress=_progressBar.getProgress();
//                progress+=10;
//                _progressBar.setProgress(progress);


//                AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
//                alertDialog.setTitle("This is AlertDialog");
//                alertDialog.setMessage("Some Important");
//                alertDialog.setCancelable(false);
//                alertDialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                alertDialog.show();


                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loadding....");
                progressDialog.setCancelable(false);
                progressDialog.show();




                break;
            }
            default:
                break;
        }
    }
}
