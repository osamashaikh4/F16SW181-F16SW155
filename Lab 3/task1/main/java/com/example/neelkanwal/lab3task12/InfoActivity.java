package com.example.neelkanwal.lab3task12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Bundle extras = getIntent().getExtras();
        TextView t8;
        t8=findViewById(R.id.textView8);
        t8.setText("Welcom "+extras.getString("userinfo"));
    }
}
