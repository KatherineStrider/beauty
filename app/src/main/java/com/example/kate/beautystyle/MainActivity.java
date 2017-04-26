package com.example.kate.beautystyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        Picasso.with(this)
                .load("http://www.dandy-dogs.ru/template/images/banner2.png")
                .into(imageView);

        RecycleViewAdapter recyclerViewAdapter = new RecycleViewAdapter(this, getResources().getStringArray(R.array.services),onNameClickListener);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    RecycleViewAdapter.OnNameClickListener onNameClickListener = new RecycleViewAdapter.OnNameClickListener() {
        @Override
        public void onNameClick(int position, String name) {
            Toast.makeText(MainActivity.this, String.format("%s #%d", name, position), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
            startActivity(intent);
        }
    };
}
