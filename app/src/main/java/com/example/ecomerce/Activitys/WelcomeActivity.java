package com.example.ecomerce.Activitys;


import com.example.ecomerce.R;
import com.example.ecomerce.Tools.UserSession;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
private static final int DURACION_MS=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);




        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                UserSession userSession=new UserSession(getApplicationContext());
                if(userSession.isLoggedIn()){
                    Intent intent=new Intent(WelcomeActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, DURACION_MS);
    }
}
