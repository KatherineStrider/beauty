package com.example.kate.beautystyle.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.example.kate.beautystyle.ListViewAdapter;
import com.example.kate.beautystyle.NumberForDetails;
import com.example.kate.beautystyle.OnServiceClickListener;
import com.example.kate.beautystyle.R;

/**
 * Created by Kate on 28.04.2017.
 */

public class ServicesInfo extends ListFragment {

    public static final String TAG = ListFragment.class.getSimpleName();
    OnServiceClickListener onServiceClickListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListViewAdapter listViewAdapter = new ListViewAdapter(getContext(), getType());
        setListAdapter(listViewAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        NumberForDetails.setNumber2ForDetails(position);
        onServiceClickListener.onServiceClick();
    }

    private String[] getType(){

        int i = NumberForDetails.num1;
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
            case 3:
                arr = getResources().getStringArray(R.array.services_geo);
                break;
            default:
                arr = null;
                break;
        }
        return arr;
    }

    public static ListFragment getInstance() {
        return new ServicesInfo();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnServiceClickListener) {
            onServiceClickListener = (OnServiceClickListener) context;
        } else {
            throw new IllegalStateException("Activity must implement ManClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onServiceClickListener = null;
    }
}
