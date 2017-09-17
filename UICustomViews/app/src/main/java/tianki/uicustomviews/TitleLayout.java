package tianki.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Tiank on 9/7/2017.
 */

public class TitleLayout extends LinearLayout{
    public  TitleLayout(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button _btnBack=(Button)findViewById(R.id.Btn_back);
        Button _btnEdit=(Button)findViewById(R.id.Btn_Edit);
        _btnBack.setOnClickListener(onClickListener);
        _btnEdit.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener=new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.Btn_back:{
                    ((Activity)getContext()).finish();
                }
                case R.id.Btn_Edit:
                    Toast.makeText(getContext(),"Poi",Toast.LENGTH_SHORT).show();
            }

        }
    };
}


