package tianki.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        FruitAdapter fruitAdapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);

    }


    private void initFruits(){
        for (int i=0;i<2;i++){
            Fruit apple=new Fruit("Apple",R.drawable.a);
            fruitList.add(apple);
            Fruit banana=new Fruit("Banana",R.drawable.b);
            fruitList.add(banana);
            Fruit orange=new Fruit("Orange",R.drawable.c);
            fruitList.add(orange);
            Fruit pear=new Fruit("Pear",R.drawable.d);
            fruitList.add(pear);
        }
    }
}
