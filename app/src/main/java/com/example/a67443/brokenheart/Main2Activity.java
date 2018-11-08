package com.example.a67443.brokenheart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("内容未发布，敬请期待");

                    Button butten = (Button)findViewById(R.id.button2);
                    butten.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText("建议直接说实话！！！更多建议未发布");

                    Button bt1 = (Button)findViewById(R.id.button2);
                    bt1.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("内容未发布");

                    Button bt2 = (Button)findViewById(R.id.button2);
                    bt2.setVisibility(View.INVISIBLE);
                    Button bt3 = (Button)findViewById(R.id.button3);
                    bt3.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button bt = (Button)findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(in);
            }
        });
        Button bt1 = (Button)findViewById(R.id.button3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,ChatActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
