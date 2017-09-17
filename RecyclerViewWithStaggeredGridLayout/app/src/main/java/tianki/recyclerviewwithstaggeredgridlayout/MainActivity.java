package tianki.recyclerviewwithstaggeredgridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager linearLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        FruitAdapter fruitAdapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruits(){
        for (int i=0;i<2;i++){
            Fruit apple=new Fruit(getRandomLengthName("Apple"),R.drawable.a);
            fruitList.add(apple);
            Fruit banana=new Fruit(getRandomLengthName("Banana"),R.drawable.b);
            fruitList.add(banana);
            Fruit orange=new Fruit(getRandomLengthName("Orange"),R.drawable.c);
            fruitList.add(orange);
            Fruit pear=new Fruit(getRandomLengthName("Pear"),R.drawable.d);
            fruitList.add(pear);
        }
    }

    private String getRandomLengthName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<length;i++){
            stringBuffer.append(name);
        }

        return stringBuffer.toString();
    }
}
