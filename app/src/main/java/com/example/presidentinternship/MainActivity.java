package com.example.presidentinternship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

    TextView create_account;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

    SQLiteDatabase db;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(ConstantSp.pref, MODE_PRIVATE);

        db = openOrCreateDatabase("PresidentInternship.db", MODE_PRIVATE, null);
        String userTable = "CREATE TABLE IF NOT EXISTS user (userid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), email VARCHAR(50), contact VARCHAR(15), password VARCHAR(20))";
        db.execSQL(userTable);


        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);
        login = findViewById(R.id.main_login);
        create_account = findViewById(R.id.create_account);


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

                    String checkUser = "SELECT * FROM user WHERE email = '"+email.getText().toString()+"' AND password = '"+password.getText().toString()+"'";
                    Cursor cursor = db.rawQuery(checkUser, null);


                    if(cursor.getCount()>0){
                        while (cursor.moveToNext()){
                            sp.edit().putString(ConstantSp.userid, cursor.getString(0)).commit();
                        }
                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(intent);
//                        Snackbar.make(view, "Login Successfull", Snackbar.LENGTH_LONG).show();
                    } else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);

//                onBackPressed();
            }
        });

    }
}