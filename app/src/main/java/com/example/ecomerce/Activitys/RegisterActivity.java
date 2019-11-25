package com.example.ecomerce.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ecomerce.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class RegisterActivity extends AppCompatActivity {
    private ImageView perfilPicture;
    private Uri uri;

    private EditText reg_txt_nombre;
    private EditText reg_txt_user;
    private EditText reg_txt_email;
    private EditText reg_txt_password;
    private EditText reg_txt_password2;
    private EditText reg_txt_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        perfilPicture = (ImageView) findViewById(R.id.perfilPicture);
        reg_txt_nombre = (EditText) findViewById(R.id.reg_txt_nombre);
        reg_txt_user = (EditText) findViewById(R.id.reg_txt_user);
        reg_txt_email = (EditText) findViewById(R.id.reg_txt_email);
        reg_txt_password = (EditText) findViewById(R.id.reg_txt_password);
        reg_txt_password2 = (EditText) findViewById(R.id.reg_txt_password2);
        reg_txt_phone = (EditText) findViewById(R.id.reg_txt_phone);

        perfilPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            try {
                uri = data.getData();
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                perfilPicture.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void onClickRegister(View view) {
        reg_txt_nombre.setText("");
        reg_txt_user.setText("");
        reg_txt_email.setText("");
        reg_txt_password.setText("");
        reg_txt_password2.setText("");
        reg_txt_phone.setText("");;
        Toast.makeText(this,R.string.register_done, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }

    public void onClickForget(View view) {
        Intent intent = new Intent(RegisterActivity.this, ForgetActivity.class);
        finish();
        startActivity(intent);

    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }
}
