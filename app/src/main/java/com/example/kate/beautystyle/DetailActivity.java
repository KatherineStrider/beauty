package com.example.kate.beautystyle;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageDetails = (ImageView) findViewById(R.id.imageDetails);
        textDetails = (TextView) findViewById(R.id.textDetails);

        getDetails();
    }

    private void getDetails(){

        int i = NumberOfDetails.num1;
        int j = NumberOfDetails.num2;
        String url = null;
        String details = null;

        /**
         * Первое стрижка, второе покраска, третье маникюр
         */
        switch (i){
            case 0:
                switch (j){
                    case 0:
                        url = "http://lalapanda.ru/media/cache/f9/05/f9050e8d6a838d01b8e65aa05fab6974.jpg";
                        details = "Лев";
                        break;
                    case 1:
                        url = "https://livefomdet.ru/uploads/images/f/o/t/foto_strizhek_kotov_3.jpg";
                        details = "Дракон";
                        break;
                    case 2:
                        url = "http://bigpicture.ru/wp-content/uploads/2015/04/square_011.jpg";
                        details = "Квадрат";
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (j){
                    case 0:
                        url = "http://izbyshki.ru/L2nD2Vd7BX58HAgTcRQoxL3fuWV1pdJG2aH/upload/2014-09/38955ac30be7ec_1411306132_55145.jpg";
                        details = "";
                        break;
                    case 1:
                        url = "http://animal-store.ru/img/2015/050317/3455622";
                        details = "";
                        break;
                    case 2:
                        url = "http://hammarlund.ru/MG_2014/I12/505080_487497.jpg";
                        details = "";
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (j){
                    case 0:
                        url = "https://i12.fotocdn.net/s13/80/public_pin_l/144/2362740559.jpg";
                        details = "";
                        break;
                    case 1:
                        url = "http://trendy-puppy.ru.fastsite.ru/uploads/20161219/Dogsi-9.jpg";
                        details = "";
                        break;
                    case 2:
                        url = "http://ahaba.ru/userimages/49510-800-600.jpg";
                        details = "";
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                url = "http://download.seaicons.com/icons/paomedia/small-n-flat/1024/map-marker-icon.png";
                details = "";
            break;
            default:
                break;
        }

        Picasso.with(this)
                .load(url)
                .into(imageDetails);
        textDetails.setText(details);
//        switch (j){
//            case 0:
//                url = "";
//                details = "";
//                break;
//            case 1:
//                url = "";
//                details = "";
//                break;
//            case 2:
//                url = "";
//                details = "";
//                break;
//            default:
//                break;
//        }
    }
}
