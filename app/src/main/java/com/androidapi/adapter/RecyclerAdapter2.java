package com.androidapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapi.R;
import com.androidapi.ui.RecyclerViewPullActivity;


/**
 * Created by zq on 2016/6/6.
 */

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>{

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.demo2_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(RecyclerViewPullActivity.list.get(position));
    }

    @Override
    public int getItemCount() {
        return RecyclerViewPullActivity.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View view){
            super(view);
            textView=(TextView) view.findViewById(R.id.item_txt);
        }
    }
}
