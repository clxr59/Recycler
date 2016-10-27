package com.moliying.cl.recyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager manager = new GridLayoutManager(this,4);
        //设置布局管理器
        recyclerView.setLayoutManager(llm);
        //设置为垂直布局，这也是默认的
        llm.setOrientation(OrientationHelper.VERTICAL);
        initData();
        recyclerView.setAdapter(new RecyclerAdapter(this,mDatas));
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
//        DividerGridItemDecoration dgid = new DividerGridItemDecoration(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
//        recyclerView.addItemDecoration(dgid);
    }

    private void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }
}
