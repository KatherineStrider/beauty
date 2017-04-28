package com.example.kate.beautystyle;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.kate.beautystyle.fragments.DetailInfo;
import com.example.kate.beautystyle.fragments.ServicesInfo;

/**
 * Created by Kate on 28.04.2017.
 */

public class ServicesActivity extends AppCompatActivity implements OnServiceClickListener {

    Fragment fragment_list;
    Fragment fragment_detail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        fragment_detail = DetailInfo.getInstance();
        fragment_list = ServicesInfo.getInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment_list, ServicesInfo.TAG)
                .addToBackStack(ServicesInfo.TAG)
                .commit();
    }

    @Override
    public void onServiceClick() {
        setFragments();
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        getSupportFragmentManager().saveFragmentInstanceState(fragment_detail);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        setFragments();
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void setFragments() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_for_detail, fragment_detail, DetailInfo.TAG)
                    .addToBackStack(DetailInfo.TAG)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment_detail, DetailInfo.TAG)
                    .addToBackStack(DetailInfo.TAG)
                    .commit();
        }
    }
}
