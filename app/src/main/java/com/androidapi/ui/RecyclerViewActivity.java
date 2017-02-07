package com.androidapi.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.androidapi.R;
import com.androidapi.adapter.RecyclerAdapter1;
import com.androidapi.presenter.IOnClickListenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zq on 2016/6/6.
 */

public class RecyclerViewActivity extends Activity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private RecyclerAdapter1 adapter;
    @SuppressLint("InlinedApi")
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
        // 设置布局管理LayoutManager
        LinearLayoutManager manager=new LinearLayoutManager(this);
        //设置水平或者垂直
        // manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        // （可选）如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerAdapter1(this,mDatas);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new IOnClickListenter() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),position+"---"+mDatas.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }
    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i <= 50; i++) {
            mDatas.add("item---" +i);
        }
    }

}
