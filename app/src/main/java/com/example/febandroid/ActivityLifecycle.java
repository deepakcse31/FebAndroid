package com.example.febandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lifecycle);
        Log.e("ActivityLifecycle","onCreate");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ActivityLifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ActivityLifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ActivityLifecycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ActivityLifecycle","onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ActivityLifecycle","onDestroy");
    }
}