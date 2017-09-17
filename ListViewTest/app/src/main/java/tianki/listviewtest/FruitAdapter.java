package tianki.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tiank on 9/7/2017.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private  int _resourceId;

    public FruitAdapter(Context context,int textViewResourceId,List<Fruit> objects){
        super(context,textViewResourceId,objects);
        _resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view =LayoutInflater.from(getContext()).inflate(_resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName=(TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
//        ImageView imageView=(ImageView)view.findViewById(R.id.fruit_image);
//        TextView textView =(TextView)view.findViewById(R.id.fruit_name);
//        imageView.setImageResource(fruit.get_ImageId());
//        textView.setText(fruit.getName());

        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.get_ImageId());
        return  view;
    }


    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
