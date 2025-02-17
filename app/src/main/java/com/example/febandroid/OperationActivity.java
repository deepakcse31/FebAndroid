package com.example.febandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperationActivity extends AppCompatActivity {
    EditText edtno1,edtno2;
    TextView tvresult;
    Button btnAdd,btnSub;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operation);
        edtno1=findViewById(R.id.edtno1);
        edtno2=findViewById(R.id.edtno2);
        tvresult=findViewById(R.id.tvresult);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataedt1=edtno1.getText().toString();
                String dataedt2=edtno2.getText().toString();
                String data=add(dataedt1,dataedt2);
                tvresult.setText("Result = "+data);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataedt1=edtno1.getText().toString();
                String dataedt2=edtno2.getText().toString();
                String data=sub(dataedt1,dataedt2);
                tvresult.setText("Result = "+data);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private String add(String no1,String no2){
            int a=Integer.parseInt(no1)+Integer.parseInt(no2);
            return String.valueOf(a);
    }
    private String sub(String no1,String no2){
        int a=Integer.parseInt(no1)-Integer.parseInt(no2);
        return String.valueOf(a);
    }
}