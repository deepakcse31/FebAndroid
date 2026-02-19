package com.example.febandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

    RecyclerView rvlist;
    ProgressBar progressbar;
    MovieAdapter recyclerViewAdapter;
    ApiService apiService;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie);

        rvlist=findViewById(R.id.rvlist);
        progressbar=findViewById(R.id.progressbar);

        apiService=ApiClient.getClient().create(ApiService.class);

        getMovie();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getMovie(){
        Call<MovieResponse> call=apiService.getMovies("Spiderman");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                Log.e("Response",response.body().getDescription().toString());
                recyclerViewAdapter=new MovieAdapter(response.body().getDescription());
                progressbar.setVisibility(View.GONE);
                rvlist.setHasFixedSize(true);
                rvlist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvlist.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}