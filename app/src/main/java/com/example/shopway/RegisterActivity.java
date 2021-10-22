package com.example.shopway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopway.model.Account;

public class RegisterActivity extends AppCompatActivity {

    private RegisterActivityViewModel viewModel;
    EditText username;
    EditText password;
    EditText name;
    EditText address;
    EditText phone;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewModel = new ViewModelProvider(this).get(RegisterActivityViewModel.class);

        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passInput);
        name = findViewById(R.id.nameInput);
        address = findViewById(R.id.addressInput);
        phone = findViewById(R.id.phoneInput);
        register = findViewById(R.id.regButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = new Account(username.getText().toString(), password.getText().toString(),
                        name.getText().toString(), address.getText().toString(), phone.getText().toString());

                int result = viewModel.registerAttempt(account).getValue();
                if(result == 0)
                {
                    Intent goToAppIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(goToAppIntent);
                } else if(result == 1)
                {
                    Toast.makeText(RegisterActivity.this, "The username is already taken", Toast.LENGTH_SHORT).show();
                } else if(result == 2)
                {
                    Toast.makeText(RegisterActivity.this, "The password is too short", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
