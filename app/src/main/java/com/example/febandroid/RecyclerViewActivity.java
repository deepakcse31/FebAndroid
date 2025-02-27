package com.example.febandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ApiService apiService;
    List<MyListData> listData;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=findViewById(R.id.rvlist);
        apiService=ApiClient.getClient().create(ApiService.class);

        listData=new ArrayList<>();
        listData.add(new MyListData("Apple","Apple is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Mango","Mango is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Banana","Banana is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Grapes","Grapes is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Orange","Orange is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Pineapple","Pineapple is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Watermelon","Watermelon is a fruit",R.drawable.app_store));
        listData.add(new MyListData("Strawberry","Strawberry is a fruit",R.drawable.app_store));
//        recyclerViewAdapter=new RecyclerViewAdapter(listData);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        recyclerView.setAdapter(recyclerViewAdapter);

        fetchData("batman");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void fetchData(String search){
        Call<Movie> call=apiService.getMovieList(search,"c8d30391");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful())
                {
                    //Log.e("Data","Data"+response.body().getSearch());
                    List<Search> searchList=response.body().getSearch();
                   // Log.e("Data","Data"+response.body().getSearch());
                    recyclerViewAdapter=new RecyclerViewAdapter(searchList,RecyclerViewActivity.this);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
                    //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
                    recyclerView.setAdapter(recyclerViewAdapter);



//                    progressBar.setVisibility(View.INVISIBLE);
//
//                    MovieAdapter adapter=new MovieAdapter(searchList,MovieActivity.this);
//                    rvmovie.setHasFixedSize(true);
//                    rvmovie.setLayoutManager(new LinearLayoutManager(MovieActivity.this));
//                    rvmovie.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });

    }


}