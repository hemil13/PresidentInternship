package com.example.presidentinternship;

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

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText email, password;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);
        login = findViewById(R.id.main_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Enter Email");
                } else if (!email.getText().toString().matches(email_pattern)) {
                    email.setError("Enter a Valid Email");

                } else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");
                } else if (password.getText().toString().length()<6) {
                    password.setError("Minimum 6 Characters");

                } else{
                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, "Login Successfull", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }
}