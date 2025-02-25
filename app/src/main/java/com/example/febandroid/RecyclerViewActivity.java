package com.example.febandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<MyListData> listData;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=findViewById(R.id.rvlist);
        listData=new ArrayList<>();
        listData.add(new MyListData("Apple","Apple is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Mango","Mango is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Banana","Banana is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Grapes","Grapes is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Orange","Orange is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Pineapple","Pineapple is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Watermelon","Watermelon is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Strawberry","Strawberry is a fruit",R.drawable.app_store));
        recyclerViewAdapter=new RecyclerViewAdapter(listData);
        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(recyclerViewAdapter);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}