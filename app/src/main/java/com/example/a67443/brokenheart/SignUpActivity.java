package com.example.a67443.brokenheart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    private EditText mUserMailForSignUp = findViewById(R.id.user_email_for_signup);
    private EditText mUserPasswordForSignUp = findViewById(R.id.user_password_for_signup);
    private Button mSignUpButton = findViewById(R.id.button_signup);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

    }

    public void signUp() {

    }
}
