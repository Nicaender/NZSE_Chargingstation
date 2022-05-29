package com.nzse_chargingstation.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btn_back_login_techniker, btn_confirm_login_techniker;
    EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_back_login_techniker = findViewById(R.id.button_back_login_techniker);
        btn_confirm_login_techniker = findViewById(R.id.button_confirm_login_techniker);
        et_username = findViewById(R.id.edittext_username);
        et_password = findViewById(R.id.edittext_password);

        btn_back_login_techniker.setOnClickListener(v -> finish());

        btn_confirm_login_techniker.setOnClickListener(v -> {
            if(et_username.getText().toString().equals("nicaender") && et_password.getText().toString().equals("nic123"))
            {
                Toast.makeText(getApplicationContext(), "Login Success!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), TechnikerActivity.class));
//                    overridePendingTransition(0, 0);
                finish();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}