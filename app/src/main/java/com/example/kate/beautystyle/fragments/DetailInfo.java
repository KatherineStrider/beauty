package com.example.kate.beautystyle.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kate.beautystyle.NumberForDetails;
import com.example.kate.beautystyle.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Kate on 28.04.2017.
 */

public class DetailInfo extends Fragment {

    public static final String TAG = DetailInfo.class.getSimpleName();

    TextView detailTextView;
    ImageView detailImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        detailTextView = (TextView) view.findViewById(R.id.textDetails);
        detailImg = (ImageView) view.findViewById(R.id.imageDetails);


        setInfo();

        return view;
    }

    private void setInfo(){

        int i = NumberForDetails.num1;
        int j = NumberForDetails.num2;
        String[] info;
        String url = null;
        String details = null;

        /**
         * Первое стрижка, второе покраска, третье маникюр
         */
        switch (i){
            case 0:
                info = getResources().getStringArray(R.array.furcut_details_url);
                url = info[j];
                info = getResources().getStringArray(R.array.furcut_details_info);
                details = info[j];
                break;
            case 1:
                info = getResources().getStringArray(R.array.painting_details_url);
                url = info[j];
                info = getResources().getStringArray(R.array.painting_details_info);
                details = info[j];
                break;
            case 2:
                info = getResources().getStringArray(R.array.manicure_details_url);
                url = info[j];
                info = getResources().getStringArray(R.array.manicure_details_info);
                details = info[j];
                break;
            case 3:
                url = getResources().getString(R.string.geo);
                details = getResources().getString(R.string.geo_info);
                break;
            default:
                break;
        }

        Picasso.with(getContext())
                .load(url)
                .into(detailImg);
        detailTextView.setText(details);
    }

    public static DetailInfo getInstance() {
        DetailInfo fragment = new DetailInfo();
        return fragment;
    }
}
