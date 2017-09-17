package tianki.recyclerviewwithgridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
        setContentView(R.layout.activity_main);initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        FruitAdapter fruitAdapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }



    private void initFruits(){
        for (int i=0;i<5;i++){
            Fruit apple=new Fruit(("Apple"),R.drawable.a);
            fruitList.add(apple);
            Fruit banana=new Fruit(("Banana"),R.drawable.b);
            fruitList.add(banana);
            Fruit orange=new Fruit(("Orange"),R.drawable.c);
            fruitList.add(orange);
            Fruit pear=new Fruit(("Pear"),R.drawable.d);
            fruitList.add(pear);
        }
    }

//    private String getRandomLengthName(String name){
//        Random random=new Random();
//        int length=random.nextInt(20)+1;
//        StringBuffer stringBuffer=new StringBuffer();
//        for (int i=0;i<length;i++){
//            stringBuffer.append(name);
//        }
//
//        return stringBuffer.toString();
//    }
}
