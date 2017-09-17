package tianki.fragmentbestpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tiank on 9/10/2017.
 */

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        NewsAdapter newsAdapter=new NewsAdapter(getNews());
        recyclerView.setAdapter(newsAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane=true;
        }
        else {
            isTwoPane=false;
        }
    }


    private List<News> getNews(){
        List<News> newsList=new ArrayList<>();
        for (int i=1;i<=50;i++){
            News news=new News();
            news.setTitle("This is news title"+i);
            news.setContent(getRandomLengthContent("This is news content"+i+"."));
            newsList.add(news);
        }
        return  newsList;
    }

    private String getRandomLengthContent(String content){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<length;i++){
            stringBuilder.append(content);
        }
        return  stringBuilder.toString();
    }



    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News> newsList;

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleText;
            public  ViewHolder(View view){
                super(view);
                newsTitleText=(TextView)view.findViewById(R.id.news_title);
            }
        }

        public NewsAdapter(List<News> newsList){
            this.newsList=newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final  ViewHolder viewHolder=new ViewHolder(view);
            //TextView textView=(TextView)view.findViewById(R.id.news_title);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news =newsList.get(viewHolder.getAdapterPosition());
                    if (isTwoPane){
                        NewsContentFragment newsContentFragment=(NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.get_title(),news.getContnet());
                    }else{
                        NewsContentActivity.actionStart(getActivity(),news.get_title(),news.getContnet());
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news=newsList.get(position);
            holder.newsTitleText.setText(news.get_title());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }
    }
}
