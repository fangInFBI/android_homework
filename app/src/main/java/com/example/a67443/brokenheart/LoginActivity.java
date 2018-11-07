package com.example.a67443.brokenheart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText mUserMailForLogin = findViewById(R.id.user_email_for_login);
    private EditText mUserPasswordForLogin = findViewById(R.id.user_password_for_login);
    private Button mLoginButton = findViewById(R.id.button_login);
    private Button mToSignUpButton = findViewById(R.id.button_to_signup);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        mToSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSignUp();
            }
        });

    }

    public void login() {

    }

    public void toSignUp() {

    }
}
