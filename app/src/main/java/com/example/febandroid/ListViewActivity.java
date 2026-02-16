package com.example.febandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        arrayList.add("Apple");
        arrayList.add("Mango");
        arrayList.add("Banana");
        arrayList.add("Orange");
        arrayList.add("Grapes");
        arrayList.add("Watermelon");
        arrayList.add("Pineapple");
        arrayList.add("Strawberry");
        arrayList.add("Kiwi");
        arrayList.add("Cherry");
        arrayList.add("Peach");
        arrayList.add("Pear");
        arrayList.add("Plum");
        arrayList.add("Lemon");
        arrayList.add("Lime");
        arrayList.add("Pomegranate");

        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView=findViewById(R.id.ivlist);
        listView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}