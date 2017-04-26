package com.example.kate.beautystyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Kate on 26.04.2017.
 */

public class ServiceActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView = new ListView(this);
        setContentView(listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,
                getType());
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NumberOfDetails.setNumber2ForDetails(position);
                Intent intent = new Intent(ServiceActivity.this, DetailActivity.class);
                startActivity(intent);
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private String[] getType(){

        int i = NumberOfDetails.num1;
        String[] arr;

        switch (i){
            case 0:
                arr = getResources().getStringArray(R.array.services_furcut);
                break;
            case 1:
                arr = getResources().getStringArray(R.array.services_painting);
                break;
            case 2:
                arr = getResources().getStringArray(R.array.services_manicure);
                break;
            default:
                arr = null;
                break;
        }
        return arr;
    }
}
