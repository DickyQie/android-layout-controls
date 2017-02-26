package com.zhangqie.statusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhangqie.statusbar.util.StatusBarUtil;

/**
 * Created by zq on 16/12/16.
 *
 * 此类便于其他Activity一同实现状态栏，只要集成此类就OK了
 *
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMainLayout();
        setStatusBar();
    }

    /**
     * 初始化布局
     */
    protected abstract void setMainLayout();


    /***
     *状态栏 (自己选颜色即可)
     */
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent));
    }
}
