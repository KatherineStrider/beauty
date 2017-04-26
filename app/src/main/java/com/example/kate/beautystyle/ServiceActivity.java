package com.example.kate.beautystyle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Kate on 26.04.2017.
 */

public class ServiceActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_type_servises);

        listView = new ListView(this);
        setContentView(listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,
                getResources().getStringArray(R.array.type_services));
        listView.setAdapter(listViewAdapter);

//        BaseAdapter adapterForList = new ListViewAdapter(this, getResources().getStringArray(R.array.type_services));
//        listView.setAdapter(adapterForList);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ServiceActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}
