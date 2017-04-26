package com.example.kate.beautystyle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kate on 26.04.2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ContactViewHolder> {

    private LayoutInflater inflater;
    private String[] strings;
    private OnNameClickListener clickListener;
    private Context context;

    public RecycleViewAdapter(Context context, String[] strings, OnNameClickListener clickListener){
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.strings = strings;
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return strings == null ? 0 : strings.length;
    }

    @Override
    public RecycleViewAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_recycle, parent, false);
        final ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = contactViewHolder.getAdapterPosition();
                if (position == RecyclerView.NO_POSITION) return;
                clickListener.onNameClick(position, strings[position]);
            }
        });
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ContactViewHolder holder, int position) {
        holder.bind(context, strings[position]);
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {

        ImageView imageTypeService;
        TextView textTypeService;

        ContactViewHolder(View itemView){
            super(itemView);

            imageTypeService = (ImageView) itemView.findViewById(R.id.imageService);
            textTypeService = (TextView) itemView.findViewById(R.id.textService);
        }

        void bind(Context context, String value){

            String url = "";

            switch (value){
                case "стрижка":
                    url = "https://pp.userapi.com/c405124/v405124786/532d/mU3dY12rZhM.jpg";
                    break;
                case "покраска":
                    url = "http://n1s2.hsmedia.ru/41/6b/73/416b7303e40fb2ce0a4ba26786f33c63/600x322_1_c095cd8a5d2cff6e98ac8691784f1db4@600x322_0x59f91261_17955022721411752153.jpeg";
                    break;
                case "маникюр":
                    url = "http://dogcity.com.ua/wp-content/uploads/2017/01/IMG_9697.jpg";
                    break;
                default:
                    break;
            }

            Picasso.with(context)
                    .load(url)
                    .into(imageTypeService);
            textTypeService.setText(value);
        }
    }

    public interface OnNameClickListener {
        void onNameClick(int position, String name);
    }
}
