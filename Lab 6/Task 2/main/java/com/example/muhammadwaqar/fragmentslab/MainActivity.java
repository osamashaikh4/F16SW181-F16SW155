package com.example.muhammadwaqar.fragmentslab;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int orientation;
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape

            ft.replace(R.id.frame1, new Main2Activity());
            ft.replace(R.id.frame2, new Main3Activity());
            ft.commit();

        } else {
            // In portrait

            ft.replace(R.id.frame1, new Main2Activity());
            ft.commit();

        }


    }


}