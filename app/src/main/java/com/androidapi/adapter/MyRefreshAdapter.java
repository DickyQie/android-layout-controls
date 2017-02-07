package com.androidapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zq on 2016/6/6.
 */

public class MyRefreshAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private RecyclerView.Adapter adapter;
    private View footerView;
    public static final int FOOTER_VIEW_TYPE = 2;

    public MyRefreshAdapter(RecyclerView.Adapter adapter, View footerView) {
        this.adapter = adapter;
        this.footerView = footerView;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount()-1) {
            return FOOTER_VIEW_TYPE;
        }
        return adapter.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FOOTER_VIEW_TYPE) {
            return new RecyclerView.ViewHolder(footerView) {
            };
        }
        return adapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) != FOOTER_VIEW_TYPE) {
            adapter.onBindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return adapter.getItemCount()+1;

    }
}
