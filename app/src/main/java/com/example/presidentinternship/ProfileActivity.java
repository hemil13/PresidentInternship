package com.example.presidentinternship;

import android.content.SharedPreferences;
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

    EditText cnfpassword, name, email, contact, password;
    Button edit, update;

    SharedPreferences sp;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sp = getSharedPreferences(ConstantSp.pref, MODE_PRIVATE);

        cnfpassword = findViewById(R.id.profile_cnfpassword);
        edit = findViewById(R.id.profile_edit);
        update = findViewById(R.id.profile_update);
        name = findViewById(R.id.profile_name);
        email = findViewById(R.id.profile_email);
        contact = findViewById(R.id.profile_contact);
        password = findViewById(R.id.profile_password);
    
        setData(false);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update.setVisibility(View.VISIBLE);
                edit.setVisibility(View.GONE);
                cnfpassword.setVisibility(View.VISIBLE);

                setData(true);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString().trim().equals("")){
                    email.setError("Enter Email");
                } else if (!email.getText().toString().matches(email_pattern)) {
                    email.setError("Enter a Valid Email");
                }

                else if(name.getText().toString().trim().equals("")){
                    name.setError("Enter Name");
                }

                else if (contact.getText().toString().trim().equals("")) {
                    contact.setError("Enter Contact");
                } else if (contact.getText().toString().length()<10) {
                    contact.setError("Enter A Valid Contact");

                } else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");
                } else if (password.getText().toString().length()<6) {
                    password.setError("Minimum 6 Characters");
                }


                else if (cnfpassword.getText().toString().trim().equals("")) {
                    cnfpassword.setError("Enter Confirm Password");
                } else if (!cnfpassword.getText().toString().matches(password.getText().toString().trim())) {
                    cnfpassword.setError("Confirm Password Doesn't Match");
                }

                else{


                    //
                    sp.edit().putString(ConstantSp.name, name.getText().toString()).commit();
                    sp.edit().putString(ConstantSp.email, email.getText().toString()).commit();
                    sp.edit().putString(ConstantSp.contact, contact.getText().toString()).commit();
                    sp.edit().putString(ConstantSp.password, password.getText().toString()).commit();

                    //

                    update.setVisibility(View.GONE);
                    edit.setVisibility(View.VISIBLE);
                    cnfpassword.setVisibility(View.GONE);

                    setData(false);
                }
            }
        });

    }

    private void setData(boolean b) {

        name.setText(sp.getString(ConstantSp.name, ""));
        email.setText(sp.getString(ConstantSp.email, ""));
        contact.setText(sp.getString(ConstantSp.contact, ""));
        password.setText(sp.getString(ConstantSp.password, ""));


        name.setEnabled(b);
        email.setEnabled(b);
        contact.setEnabled(b);
        password.setEnabled(b);
    }


}