package com.panpass.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.recyclerview);
        nameList.add("王一");
        nameList.add("张二");
        nameList.add("李三");
        nameList.add("赵四");
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyAdapter(nameList));
        int width = getWindowManager().getDefaultDisplay().getWidth();
        Log.e("www","----"+width);
    }
}