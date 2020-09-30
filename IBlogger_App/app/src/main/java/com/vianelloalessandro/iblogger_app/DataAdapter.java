package com.vianelloalessandro.iblogger_app;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Post> posts;

    public DataAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_title.setText(posts.get(i).getTitle());
        viewHolder.tv_content.setText(posts.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title,tv_content;
        public ViewHolder(View view) {
            super(view);

            tv_title = (TextView)view.findViewById(R.id.tv_title_row);
            tv_content = (TextView)view.findViewById(R.id.tv_content_row);

        }
    }

}
