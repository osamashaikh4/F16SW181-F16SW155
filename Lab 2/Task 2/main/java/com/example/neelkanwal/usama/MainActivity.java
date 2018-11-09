package com.example.neelkanwal.usama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    int counter=0;
    String name[] = {"Osama","Areesha"};
    String game[] = {"F16SW181","F16SW155"};
    String mail[] = {"shykhosama@gmail.com" , "areeshatalpur@gmail.com"};
    TextView nameview, gameview, emailview;
    Button prev, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameview=findViewById(R.id.textView);
        gameview=findViewById(R.id.textView2);
        emailview=findViewById(R.id.textView3);
        prev=findViewById(R.id.button);
        next=findViewById(R.id.button2);
    }
    public void prevpress(View v){
        counter--;
        if (counter<0){
            counter=name.length-1;
        }
        nameview.setText(name[counter]);
        gameview.setText(game[counter]);
        emailview.setText(mail[counter]);
    }
    public void nextpress(View v){
        counter++;
        if(counter==name.length) {
            counter = 0;
        }
        nameview.setText(name[counter]);
        gameview.setText(game[counter]);
        emailview.setText(mail[counter]);

    }
}

