package com.example.presidentinternship;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    EditText cnfpassword;
    Button edit, update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        cnfpassword = findViewById(R.id.profile_cnfpassword);
        edit = findViewById(R.id.profile_edit);
        update = findViewById(R.id.profile_update);




        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update.setVisibility(View.VISIBLE);
                edit.setVisibility(View.GONE);
                cnfpassword.setVisibility(View.VISIBLE);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update.setVisibility(View.GONE);
                edit.setVisibility(View.VISIBLE);
                cnfpassword.setVisibility(View.GONE);
            }
        });

    }
}