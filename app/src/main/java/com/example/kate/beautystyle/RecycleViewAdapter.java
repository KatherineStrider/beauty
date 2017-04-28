package com.example.kate.beautystyle;

import android.content.Context;
import android.content.res.Configuration;
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
                NumberForDetails.setNumber1ForDetails(contactViewHolder.getAdapterPosition());
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

        private final String FURCUT = "Стрижка";
        private final String PAINTING = "Покраска";
        private final String MANICURE = "Маникюр";
        private final String OUR_GEO = "Наш адрес";

        ContactViewHolder(View itemView){
            super(itemView);

            imageTypeService = (ImageView) itemView.findViewById(R.id.imageService);
            textTypeService = (TextView) itemView.findViewById(R.id.textService);
        }

        void bind(Context context, String value){

            String url = "";

            switch (value){
                case FURCUT:
                    url = context.getString(R.string.furcut_img);
                    break;
                case PAINTING:
                    url = context.getString(R.string.painting_img);
                    break;
                case MANICURE:
                    url = context.getString(R.string.manicure_img);
                    break;
                case OUR_GEO:
                    url = context.getString(R.string.geo);
                    break;
                default:
                    break;
            }

            Picasso.with(context)
                    .load(url)
                    .into(imageTypeService);
            textTypeService.setText(value);
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                textTypeService.setTextSize(22);
            }else {
                textTypeService.setTextSize(30);
            }
        }
    }

    public interface OnNameClickListener {
        void onNameClick(int position, String name);
    }
}
