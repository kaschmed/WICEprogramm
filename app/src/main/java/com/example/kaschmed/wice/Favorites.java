package com.example.kaschmed.wice;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity implements AdapterView.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ListView listView1 = (ListView) findViewById(R.id.myfavorites);

        List<String> dataSource1 = new ArrayList<>();
        dataSource1.add("Test1");//hier kommen die favorites rein, die ich haben will
        dataSource1.add("Test2");

        listView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSource1));
        listView1.setOnItemClickListener(this);


        ListView listView2 = (ListView) findViewById(R.id.myrecipe);

        List<String> dataSource2 = new ArrayList<>();
        dataSource2.add("Penne");
        dataSource2.add("Strudel");

        listView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSource2));
        listView2.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}