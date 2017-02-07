package com.androidapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidapi.R;

import java.util.List;

/**
 * Created by zq on 2016/6/6.
 */

public class CardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<String> list;
    private static final int TYPE_ITEM   = 0;
    private static final int TYPE_FOOTER = 1;
    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE     = 1;
    //没有加载更多 隐藏
    public static final int NO_LOAD_MORE     = 2;

    //上拉加载更多状态-默认为0
    private int mLoadMoreStatus = 0;
    public CardViewAdapter(Context context,List<String> list)
    {
        this.context=context;
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE_ITEM)
        {
            View view= LayoutInflater.from(context).inflate(R.layout.demo3_item,parent,false);
            return new ViewHolder(view);
        }else if(viewType==TYPE_FOOTER){
            View view= LayoutInflater.from(context).inflate(R.layout.demo3_progess,parent,false);
            return new FooterViewHolder(view);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder)
        {
            ((ViewHolder) holder).mTextView.setText(list.get(position));
        }else if(holder instanceof FooterViewHolder)
        {
            switch (mLoadMoreStatus){
                case PULLUP_LOAD_MORE:
                    ((FooterViewHolder) holder).mRelativelayout.setVisibility(View.GONE);
                    break;
                case LOADING_MORE:
                    ((FooterViewHolder) holder).mRelativelayout.setVisibility(View.VISIBLE);
                    ((FooterViewHolder) holder).mTextView.setText("正加载更多...");
                    break;
                case NO_LOAD_MORE:
                    ((FooterViewHolder) holder).mRelativelayout.setVisibility(View.GONE);
                    break;
            }
        }
    }
    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            //最后一个item设置为footerView
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }
    public void addHeaderData(List<String> data)
    {
        list.addAll(0,data);
        notifyDataSetChanged();
    }
    public void addFooterData(List<String> data){
        list.addAll(data);
        notifyDataSetChanged();
    }
    /**
     * 更新加载更多状态
     * @param status
     */
    public void changeMoreStatus(int status){
        mLoadMoreStatus=status;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public ViewHolder(View view){
            super(view);
            mTextView=(TextView) view.findViewById(R.id.tvContent);
        }
    }
    public class FooterViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        ProgressBar mProgressBar;
        RelativeLayout mRelativelayout;
        public FooterViewHolder(View view)
        {
            super(view);
            mTextView=(TextView)view.findViewById(R.id.tvLoadText);
            mProgressBar=(ProgressBar) view.findViewById(R.id.pbLoad);
            mRelativelayout=(RelativeLayout) view.findViewById(R.id.loadLayout);
        }


    }


}
