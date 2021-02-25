package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ListViews uses an adapter to convert an array to a scrollable list in GUI form
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colors = {"Orange", "Blue" , "Grey", "Black", "White", "Red", "Green", "Taupe",
                "Orange", "Blue" , "Grey", "Black", "White", "Red", "Green", "Taupe"};

        //Initilize adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, colors);

        //Link listView to list_view from activity.xml
        listView = findViewById(R.id.list_view);
        //Set adapter for listView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String s = (String) adapterView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}