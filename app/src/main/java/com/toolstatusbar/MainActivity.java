package com.toolstatusbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                startActivity(new Intent(MainActivity.this,TooBarStatusActivity1.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this,TooBarStatusActivity2.class));
                break;
        }
    }
}
