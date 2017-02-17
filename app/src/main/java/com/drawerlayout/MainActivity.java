package com.drawerlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends FragmentActivity implements OnItemClickListener,OnClickListener{

    private DrawerLayout drawerLayout;
    private ListView listView;
    private FragmentManager fragmentManager;
    private Fragment fragment1, fragment2, fragment3;
    private String[] str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_logo).setOnClickListener(this);
        initView();
    }

    private void initView() {
        // TODO Auto-generated method stub
        drawerLayout=(DrawerLayout) findViewById(R.id.id_drawerlayout);
        drawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        });
        listView=(ListView) findViewById(R.id.listview);
        str = new String[] { "时间", "地点", "人物"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, str);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        fragmentManager = getSupportFragmentManager();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        //drawerLayout.openDrawer(Gravity.LEFT);//侧滑打开  不设置则不会打开

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        switch (position) {
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.id_framelayout2, fragment1).commit();
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.id_framelayout2, fragment2).commit();
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.id_framelayout2, fragment3).commit();
                break;
        }
        setTitle(str[position]);
        drawerLayout.closeDrawers();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent=new Intent();
        intent.setClass(getApplicationContext(), DrawerActivity.class);
        startActivity(intent);
    }

}

