package com.example.kate.beautystyle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView imageView;
    private RecycleViewAdapter recyclerViewAdapter;
    private final int posForGeo = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        Picasso.with(this)
                .load(getString(R.string.main_img))
                .into(imageView);

        recyclerViewAdapter = new RecycleViewAdapter(this, getResources()
                .getStringArray(R.array.services),onNameClickListener);

        recyclerView.setAdapter(recyclerViewAdapter);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        }
    }

    RecycleViewAdapter.OnNameClickListener onNameClickListener = new RecycleViewAdapter
            .OnNameClickListener() {
        @Override
        public void onNameClick(int position, String name) {
            NumberForDetails.setNumber1ForDetails(position);
            Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
            startActivity(intent);
        }
    };
}
