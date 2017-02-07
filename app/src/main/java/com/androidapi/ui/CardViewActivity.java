package com.androidapi.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidapi.R;
import com.androidapi.adapter.CardViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zq on 2016/6/6.
 */
public class CardViewActivity extends Activity {
    public RecyclerView mRecyclerView;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public List<String> mDatas = new ArrayList<>();
    public LinearLayoutManager mLinearLayoutManager;
    public CardViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo3);
        initView();
        initData();
        initModerl();
    }
    private void initView() {
        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        mSwipeRefreshLayout=(SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE, Color.GREEN);

    }

    private void initData() {
        for (int i = 0; i < 10; i++) {

            mDatas.add("数据"+i);
        }
        initRecylerView();
    }
    private void initRecylerView() {
        adapter = new CardViewAdapter(this,mDatas);
        mLinearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String>  lists=new ArrayList<String>();
                        for (int i = 25; i <30; i++) {
                            lists.add("下拉刷新数据"+i);
                        }
                        adapter.addHeaderData(lists);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                },1500);
            }
        });
    }

    private void initModerl()
    {

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            int lastVisibleItem ;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE && (lastVisibleItem+1)==adapter.getItemCount())
                {
                    adapter.changeMoreStatus(adapter.LOADING_MORE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<String> footerDatas = new ArrayList<String>();
                            for (int i = 0; i< 10; i++) {

                                footerDatas.add("上拉刷新数据" + i);
                            }
                            adapter.addFooterData(footerDatas);
                            adapter.changeMoreStatus(adapter.PULLUP_LOAD_MORE);
                        }
                    },1500);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //最后一个可见的ITEM的数目
                lastVisibleItem=layoutManager.findLastVisibleItemPosition();
            }
        });
    }

}
