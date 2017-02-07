package com.androidapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidapi.ui.CardViewActivity;
import com.androidapi.ui.RecycleViewUIActivity;
import com.androidapi.ui.RecyclerViewActivity;
import com.androidapi.ui.RecyclerViewPullActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    String[] str=new String[]{"recyclerview简单使用+Item中自定义分割线","RecyclerView上拉刷新下拉加载","RecyclerView实现两种不同Item布局","CardView简单使用+上拉刷新下拉加载"
    };
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVire();
    }

    void initVire(){
        listview=(ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,showData());
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onItemClickListener);
    }
    private List<String> showData()
    {
        List<String> list=new ArrayList<String>();
        for (int i=0;i<str.length;i++)
        {
            list.add(str[i]);
        }
        return list;
    }

    AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    intent=new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case 1:
                    intent=new Intent(MainActivity.this, RecyclerViewPullActivity.class);
                    break;

                case 2:
                    intent=new Intent(MainActivity.this, RecycleViewUIActivity.class);
                    break;
                case 3:
                    intent=new Intent(MainActivity.this, CardViewActivity.class);
                    break;
                /*
                case 4:
                    intent=new Intent(MainActivity.this, Demo5.class);
                    break;
                case 5:
                    intent=new Intent(MainActivity.this, Demo6.class);
                    break;
                case 6:
                    intent=new Intent(MainActivity.this, Demo7.class);
                    break;
                case 7:
                    intent=new Intent(MainActivity.this, Demo8.class);
                    break;
                case 8:
                    intent=new Intent(MainActivity.this, Demo9.class);
                    break;
                case 9:
                    intent=new Intent(MainActivity.this, Demo9_1.class);

                    break;*/
            }
            startActivity(intent);
        }
    };
}
