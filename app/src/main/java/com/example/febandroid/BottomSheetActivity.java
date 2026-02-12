package com.example.febandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BottomSheetActivity extends AppCompatActivity {
    Button btnbottomsheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottom_sheet);
        btnbottomsheet=findViewById(R.id.btnbottomsheet);


        btnbottomsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomBottomSheet customBottomSheet=new CustomBottomSheet();
                customBottomSheet.show(getSupportFragmentManager(),"CustomBottomSheet");

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}