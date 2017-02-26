package com.zhangqie.statusbar;

import android.content.Intent;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void setMainLayout() {
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BackImaActivity.class));
            }
        });
    }
}
