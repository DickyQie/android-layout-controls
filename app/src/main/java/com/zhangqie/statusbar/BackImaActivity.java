package com.zhangqie.statusbar;

import android.view.View;

import com.zhangqie.statusbar.util.StatusBarUtil;


/**
 * Created by zq on 16/12/16.
 *
 */

public class BackImaActivity extends BaseActivity {

    @Override
    protected void setMainLayout() {
        setContentView(R.layout.back_activity);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatusBarUtil.setTranslucent(BackImaActivity.this,111);
            }
        });
    }
    /****
     * 重写父类方法，覆盖的作用，可以实现状态栏的不同颜色或背景
     */
    protected void setStatusBar() {

        /**
         * 参数
         * 第一个：当前上下文
         * 第二个：状态栏透明程度，值越大就越暗 0表示完全安背景显示  之范围（0-->255）
         */

        StatusBarUtil.setTranslucent(this,0);
    }
}
