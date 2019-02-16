package com.example.muhammadwaqar.fragmentslab;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends Fragment {

    View view;
    ListView listView;
    ArrayAdapter<String>arr;
    ArrayList<String> data;
    int orientation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        view = inflater.inflate(R.layout.activity_main2 , container, false);


        listView=view.findViewById(R.id.listView);
        data=new ArrayList<>();
        for(int i =1;i<200;i++){
            data.add("F16SW"+i);
        }

        arr=new ArrayAdapter<>(getContext(),android.R.layout.simple_expandable_list_item_1,data);
        listView.setAdapter(arr);

        orientation = getResources().getConfiguration().orientation;
        if(orientation==Configuration.ORIENTATION_PORTRAIT) {


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getContext(), Main4Activity.class);
                    intent.putExtra("rollnumber", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
            });

        }


        else if(orientation==Configuration.ORIENTATION_LANDSCAPE) {


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(getContext(),listView.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        return view;

    }
}