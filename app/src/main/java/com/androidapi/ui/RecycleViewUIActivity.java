package com.androidapi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidapi.R;
import com.androidapi.adapter.RecyclerAdapter3;
import com.androidapi.view.MyItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zq on 2016/6/6.
 */

public class RecycleViewUIActivity extends Activity {
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private RecyclerAdapter3 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);
        initData();
        initView();
    }
    private void initView()
    {
        recyclerView=(RecyclerView) findViewById(R.id.demo1_recycler);
        adapter=new RecyclerAdapter3(mDatas);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyItemDecoration());
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        //调用以下方法让RecyclerView的第一个条目仅为1列
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //如果位置是0，那么这个条目将占用SpanCount()这么多的列数，再此也就是3
                //而如果不是0，则说明不是Header，就占用1列即可
                return adapter.isHeander(position) ? layoutManager.getSpanCount() : 1;
            }
        });

        //把LayoutManager设置给RecyclerView
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i <= 8; i++) {
            mDatas.add("item---" +i);
        }
    }



}
