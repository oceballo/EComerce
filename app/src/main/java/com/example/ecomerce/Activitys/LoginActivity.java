package com.example.ecomerce.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecomerce.Entity.User;
import com.example.ecomerce.R;
import com.example.ecomerce.Tools.UserSession;

public class LoginActivity extends AppCompatActivity {
    private EditText ediTextUsuario;
    private EditText ediTextPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ediTextUsuario=(EditText)findViewById(R.id.login_email);
        ediTextPass=(EditText)findViewById(R.id.login_password);

        ediTextUsuario.setText("odaliceballopimentel@gmail.com");
        ediTextPass.setText("1234");

    }

    public void onClickLogin(View view) {
        if(ediTextUsuario.getText().toString().trim().equals("odaliceballopimentel@gmail.com")&ediTextPass.getText().toString().equals("1234")) {
            UserSession userSession=new UserSession(getApplicationContext());
            userSession.createLoginSession(new User("Odali Ceballo", "oceballo", "1234", "odaliceballopimentel@gmail.com",true));

            Intent intent=new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show();
        }
    }
    public void onClickForget(View view) {
        Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
        finish();
        startActivity(intent);

    }
    public void onClickRegister(View view) {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
