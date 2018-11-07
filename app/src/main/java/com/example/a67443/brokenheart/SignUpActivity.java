package com.example.a67443.brokenheart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private EditText mUserMailForSignUp;
    private EditText mUserPasswordForSignUp;
    private Button mSignUpButton;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_signup);

        mUserMailForSignUp = findViewById(R.id.user_email_for_signup);
        mUserPasswordForSignUp = findViewById(R.id.user_password_for_signup);
        mSignUpButton = findViewById(R.id.button_signup);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

    }

    public void signUp() {
        String userMail = mUserMailForSignUp.getText().toString();
        String userPassword = mUserPasswordForSignUp.getText().toString();

        if (TextUtils.isEmpty(userMail)) {
            Toast.makeText(getApplicationContext(), "Enter E-Mail Address! ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(getApplicationContext(), "Enter Password! ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userPassword.length() < 6) {
            Toast.makeText(getApplicationContext(), getString(R.string.minimum_password), Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(userMail, userPassword)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(
                                SignUpActivity.this,
                                "createUserWithEmail:onComplete:" + task.isSuccessful(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (task.isSuccessful()) {
                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(
                                    SignUpActivity.this,
                                    "Authentication failed. " + task.getException(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                });
    }

}
