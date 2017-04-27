package com.example.kate.beautystyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kate on 26.04.2017.
 */

public class DetailActivity extends AppCompatActivity {

    ImageView imageDetails;
    TextView textDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageDetails = (ImageView) findViewById(R.id.imageDetails);
        textDetails = (TextView) findViewById(R.id.textDetails);

        setInfo();
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

        Picasso.with(this)
                .load(url)
                .into(imageDetails);
        textDetails.setText(details);
    }
}
