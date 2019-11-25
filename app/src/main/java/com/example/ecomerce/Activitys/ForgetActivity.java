package com.example.ecomerce.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecomerce.R;

public class ForgetActivity extends AppCompatActivity {
    private EditText forget_txt_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        forget_txt_email=(EditText)findViewById(R.id.forget_txt_email);
    }

    public void onClickForget(View view) {
        Toast.makeText(this, "Su Password es: 1234", Toast.LENGTH_SHORT).show();
        forget_txt_email.setText("");
    }

    public void onClickRegister(View view) {
        Intent intent = new Intent(ForgetActivity.this, RegisterActivity.class);
        finish();
        startActivity(intent);
    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(ForgetActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }
}
