package com.example.a67443.brokenheart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class StartImg  extends Activity{
          private final int SPLASH_DISPLAY_LENGHT = 4000;  //延迟3秒

    @Override
    public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.star_img);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(StartImg.this, MainActivity.class);
                    StartImg.this.startActivity(intent);
                    StartImg.this.finish();
                }
            }, SPLASH_DISPLAY_LENGHT);
    }
}
