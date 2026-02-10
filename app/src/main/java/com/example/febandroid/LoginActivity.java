package com.example.febandroid;

import android.content.Intent;
import android.os.Bundle;
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
    EditText edtPhone, edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNo=edtPhone.getText().toString();
                String password=edtPassword.getText().toString();

                if(mobileNo.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Mobile No",Toast.LENGTH_LONG).show();
                }else if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
                } else if (mobileNo.length()!=10) {
                    Toast.makeText(getApplicationContext(), "Enter Valid Mobile No", Toast.LENGTH_LONG).show();
                } else if (mobileNo.equals("9876543210") && password.equals("12345")) {
                    Intent intent=new Intent(LoginActivity.this,ActivityLifeCycle.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();

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