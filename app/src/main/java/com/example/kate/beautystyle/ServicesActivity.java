package com.example.kate.beautystyle;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kate.beautystyle.fragments.DetailInfo;
import com.example.kate.beautystyle.fragments.ServicesInfo;

/**
 * Created by Kate on 28.04.2017.
 */

public class ServicesActivity extends AppCompatActivity implements OnServiceClickListener {

    Fragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Log.d("supertag", "Мы в Services");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, ServicesInfo.getInstance(), ServicesInfo.TAG)
                .addToBackStack(ServicesInfo.TAG)
                .commit();
    }

    @Override
    public void onServiceClick() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_for_detail, DetailInfo.getInstance(), DetailInfo.TAG)
                    .addToBackStack(DetailInfo.TAG)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, DetailInfo.getInstance(), DetailInfo.TAG)
                    .addToBackStack(DetailInfo.TAG)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
//        else if(getSupportFragmentManager().getBackStackEntryCount() < 1
//                || getSupportFragmentManager().getBackStackEntryCount() == 2 && getResources()
//                .getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
//            this.finish();
//        }
        else {
            super.onBackPressed();
            this.finish();
        }
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }
}
