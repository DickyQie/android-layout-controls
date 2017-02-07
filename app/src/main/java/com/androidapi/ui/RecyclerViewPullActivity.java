package com.androidapi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.androidapi.R;
import com.androidapi.adapter.RecyclerAdapter2;
import com.androidapi.widget.MyRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zq on 2016/6/6.
 */

public class RecyclerViewPullActivity extends Activity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private MyRefreshRecyclerView recyclerView;
    public static  List<String> list=new ArrayList<String>();
    private RecyclerAdapter2 adapter;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo2);
        initView();
    }
    private void initView(){
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        recyclerView = (MyRefreshRecyclerView) findViewById(R.id.recycler);
        adapter=new RecyclerAdapter2();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        swipeRefreshLayout.setColorSchemeResources(R.color.blue,R.color.green);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        },1500);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
            }
        });
        recyclerView.setMyRefreshRecyclerViewListener(new MyRefreshRecyclerView.MyRefreshRecyclerViewListener() {
            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (list.size() > 14) {
                            recyclerView.setLoadMore(true);
                        } else {
                            int randomInt = new Random().nextInt(100);
                            list.add("上拉加载添加数字:" + randomInt);
                            adapter.notifyDataSetChanged();
                            recyclerView.setLoadMore(false);
                        }

                    }
                }, 1000);
            }
        });
    }

    private void getData() {
        list.clear();
        Random random = new Random();
        while (list.size() < 12) {
            int randomInt = random.nextInt(100);
            list.add(String.valueOf(randomInt));
        }
    }
}
