package com.androidapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapi.R;
import com.androidapi.presenter.IOnClickListenter;

import java.util.List;

/**
 * Created by zq on 2016/6/6.
 */

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.ViewHolder>{

    private Context context;
    private List<String> list;
    public RecyclerAdapter1(Context context, List<String> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.demo1_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private IOnClickListenter onClickListenter=null;
    public void setOnItemClickListener(IOnClickListenter listener)
    {
        this.onClickListenter=listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;

        public ViewHolder(View view)
        {
            super(view);
            textView=(TextView)view.findViewById(R.id.textview1);
            textView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (onClickListenter != null) {
                onClickListenter.onItemClick(v,getPosition());
            }
        }
    }
}
