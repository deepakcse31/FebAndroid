package com.example.febandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edtxtmobile,edtpassword;
    Button btnsignin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtxtmobile=findViewById(R.id.edmobile);
        edtpassword=findViewById(R.id.edtpassword);
        btnsignin=findViewById(R.id.btnsignin);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId=edtxtmobile.getText().toString();
                String password=edtpassword.getText().toString();
                if (userId.equals("9876543210") && password.equals("12345")){
                    Log.e("Login","Login Success to Home Screen");
                    Intent intent=new Intent(getApplicationContext(), ActivityLifecycle.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Login Succesful",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}