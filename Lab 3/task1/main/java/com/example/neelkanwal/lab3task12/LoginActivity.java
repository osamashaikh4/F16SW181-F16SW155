package com.example.neelkanwal.lab3task12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText et4, et5;
    TextView t7;
    Button b2;
    String userkey;
    String passkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle extras = getIntent().getExtras();
        userkey=extras.getString("userkey");
        passkey=extras.getString("passkey");
        et4 = findViewById(R.id.editText4);
        et5 = findViewById(R.id.editText5);
        t7 = findViewById(R.id.textView7);
        b2 = findViewById(R.id.button2);
    }
    public void login(View v){
        String username2 = et4.getText().toString();
        String password2 = et5.getText().toString();
        if(username2.equals(userkey) && password2.equals(passkey)){
            Intent i = new Intent(getApplicationContext(), InfoActivity.class);
            i.putExtra("userinfo", username2);
            startActivity(i);
        }
        else
            t7.setText("username or password incorrect");
    }
}
