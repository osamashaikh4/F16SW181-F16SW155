package com.example.neelkanwal.lab3task12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1, et3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        et3 = findViewById(R.id.editText3);
        b1 = findViewById(R.id.button);
    }
    public void signup(View v){
        Intent in = new Intent(getApplicationContext(), LoginActivity.class);
                String username;
                String password;
        username = et1.getText().toString();
        password = et3.getText().toString();
        in.putExtra("userkey", username);
        in.putExtra("passkey", password);
        startActivity(in);
    }
}
