package com.androidapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidapi.R;

import java.util.List;

/**
 * Created by zq on 2016/6/6.
 */

public class RecyclerAdapter3 extends RecyclerView.Adapter {

    //先定义两个ItemViewType，0代表头，1代表表格中间的部分
    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_ITEM = 1;

    private List<String>  list;

    public RecyclerAdapter3(List<String>  list)
    {
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==ITEM_VIEW_TYPE_HEADER)
        {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo4_header,null));
        }
        else {
            return new BodyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo4_body,null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isHeander(position))
        {
            ((ViewHolder)holder).imageView.setImageResource(R.mipmap.ls);
        }else{
            ((BodyViewHolder)holder).textView.setText(list.get(position-1));
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }
    /**
     *
     * 复用getItemViewType方法，根据位置返回相应的ViewType
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        //如果是0，就是头，否则则是其他的item
        return isHeander(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
    }
    public boolean isHeander(int position)
    {
        return position==0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ViewHolder(View view){
            super(view);
            imageView=(ImageView) view.findViewById(R.id.img);
        }

    }


    public class BodyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public BodyViewHolder(View view)
        {
            super(view);
            textView=(TextView)view.findViewById(R.id.item_tv);
        }


    }

}
