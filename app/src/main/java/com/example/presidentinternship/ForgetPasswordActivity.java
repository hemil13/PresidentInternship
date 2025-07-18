package com.example.presidentinternship;

import android.database.sqlite.SQLiteDatabase;
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

import java.util.concurrent.ForkJoinTask;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText email, newPassword, newCnfPassword;
    Button update_password;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        db = openOrCreateDatabase("PresidentInternship.db", MODE_PRIVATE, null);
        String userTable = "CREATE TABLE IF NOT EXISTS user (userid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), email VARCHAR(50), contact VARCHAR(15), password VARCHAR(20))";
        db.execSQL(userTable);

        email = findViewById(R.id.forget_email);
        newPassword = findViewById(R.id.new_password);
        newCnfPassword = findViewById(R.id.new_cnfpassword);
        update_password = findViewById(R.id.update_password);


        update_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String updatePassword = "UPDATE user SET password = '"+newPassword.getText().toString()+"' WHERE email = '"+email.getText().toString()+"'";
                db.execSQL(updatePassword);

                Toast.makeText(ForgetPasswordActivity.this, "Password Changed Successfully", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

    }
}