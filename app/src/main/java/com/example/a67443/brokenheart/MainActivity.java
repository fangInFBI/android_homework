package com.example.a67443.brokenheart;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.roger.catloadinglibrary.CatLoadingView;

public class MainActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 4000;  //延迟3秒
    private FirebaseAuth mAuth;
    private Button mLogOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        setContentView(R.layout.activity_main);

        Button bt = (Button)findViewById(R.id.button);
        mLogOutButton = findViewById(R.id.button_logout);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CatLoadingView view = new CatLoadingView();
                view.show(getSupportFragmentManager(),"");

                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                        finish();
                    }
                },SPLASH_DISPLAY_LENGHT);
//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//                startActivity(intent);
            }
        });

        // Temp LogOut
        mLogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Successfully Log Out! ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
