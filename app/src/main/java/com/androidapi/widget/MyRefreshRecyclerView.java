package com.androidapi.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidapi.adapter.MyRefreshAdapter;
import com.androidapi.view.CircleProgressView;

/**
 * Created by zq on 2016/6/6.
 */

public class MyRefreshRecyclerView extends RecyclerView {

    private MyRefreshAdapter myRefreshAdapter;
    private View footerView;
    private MyRefreshRecyclerViewListener myRefreshRecyclerViewListener;
    private boolean isLoadMore;
    private TextView loadTxt;
    private CircleProgressView circleProgressView;


    public void setMyRefreshRecyclerViewListener(MyRefreshRecyclerViewListener myRefreshRecyclerViewListener) {
        this.myRefreshRecyclerViewListener = myRefreshRecyclerViewListener;
    }

    public MyRefreshRecyclerView(Context context) {
        super(context);
        init();
    }

    public MyRefreshRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRefreshRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    private void init() {
        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //停止滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示Item的Position
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();
                    // 判断是否滚动到底部，并且不在加载状态
                    if (lastVisibleItem == (totalItemCount - 1) && !isLoadMore) {
                        isLoadMore = true;
                        loadTxt.setText("正在加载...");
                        circleProgressView.setVisibility(VISIBLE);
                        footerView.setVisibility(VISIBLE);
                        myRefreshRecyclerViewListener.onLoadMore();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void setAdapter(Adapter adapter) {
        LinearLayout footerLayout = new LinearLayout(getContext());
        footerLayout.setGravity(Gravity.CENTER);
        footerLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 160));
        circleProgressView = new CircleProgressView(getContext());
        circleProgressView.setLayoutParams(new LinearLayout.LayoutParams(80, 80));
        circleProgressView.startAnimation();
        footerLayout.addView(circleProgressView);
        loadTxt = new TextView(getContext());
        footerLayout.addView(loadTxt);
        footerView = footerLayout;
        footerView.setVisibility(GONE);
        myRefreshAdapter = new MyRefreshAdapter(adapter, footerView);
        super.setAdapter(myRefreshAdapter);
    }

    public interface MyRefreshRecyclerViewListener {
        void onLoadMore();
    }

    public void setLoadMore(boolean complete) {
        if (complete) {
            loadTxt.setText("已经全部加载完啦!");
            circleProgressView.setVisibility(GONE);
        } else {
            footerView.setVisibility(GONE);
        }
        isLoadMore = false;
    }

}
