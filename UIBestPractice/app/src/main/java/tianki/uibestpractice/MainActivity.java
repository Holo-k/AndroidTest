package tianki.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private  MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        inputText=(EditText) findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);
        msgAdapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if (!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setTag("");
                }
            }
        });
    }

    private  void initMsg(){
        Msg msg =new Msg("Hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg);
        Msg msg1=new Msg("Hello. Who is that?",Msg.TYPE_SENT);
        msgList.add(msg1);
        Msg msg2=new Msg("This is Tom. Nice talking to you.",Msg.TYPE_RECEIVED);
        msgList.add(msg2);
    }
}
