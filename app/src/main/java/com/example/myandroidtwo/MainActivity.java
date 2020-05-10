package com.example.myandroidtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Item> adapter =  new ArrayAdapter<>(this, R.layout.item_adapter, R.id.txt_name, Item.getItems());
        ListView listView = (ListView) findViewById(R.id.list_items);
        listView.setAdapter(adapter);
    }
}
