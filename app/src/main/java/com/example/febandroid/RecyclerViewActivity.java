package com.example.febandroid;

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
    RecyclerView rvlist;
    List<MyListData> listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        rvlist=findViewById(R.id.rvlist);
        listdata=new ArrayList<>();
        listdata.add(new MyListData("Apple","Apple Description",R.mipmap.app_icon));
        listdata.add(new MyListData("Mango","Mango Description",R.mipmap.app_icon));
        listdata.add(new MyListData("Banana","Banana Description",R.mipmap.app_icon));
        listdata.add(new MyListData("Orange","Orange Description",R.mipmap.app_icon));
        listdata.add(new MyListData("Grapes","Grapes Description",R.mipmap.app_icon));


        RecyclerViewAdapter adapter=new RecyclerViewAdapter(listdata);
        rvlist.setHasFixedSize(true);
        rvlist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //rvlist.setLayoutManager(new LinearLayoutManager(this));
        rvlist.setAdapter(adapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}