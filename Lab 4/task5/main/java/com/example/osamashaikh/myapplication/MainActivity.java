package com.example.muhammadwaqar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView programingList = findViewById(R.id.programming);
        programingList.setLayoutManager(new LinearLayoutManager(this));
        String[] languages = {"Java", "C++", "C","Javascript","PHP","R","Python","Perl", "Ruby on Rail", "C#"};
        programingList.setAdapter(new programingAdapter(languages));
    }
}
