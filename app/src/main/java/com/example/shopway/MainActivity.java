package com.example.shopway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopway.model.Account;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    TextView register;
    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        register = findViewById(R.id.registerText);
        username = findViewById(R.id.nameInput);
        password = findViewById(R.id.passInput);
        login = findViewById(R.id.loginButton);


       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Boolean result = viewModel.verifyLogin(username.getText().toString(), password.getText().toString()).getValue();
               if (result == true)
               {
                   Intent appIntent = new Intent(MainActivity.this, MainAppActivity.class);
                   startActivity(appIntent);
               } else {
                   Toast.makeText(MainActivity.this, "balal", Toast.LENGTH_SHORT).show();
               }
           }
       });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}