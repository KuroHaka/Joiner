package com.example.joiner.interfaz;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.joiner.R;

import java.util.List;

public class AdapterEmpleado extends PagerAdapter {

    private List<Modelo> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterEmpleado(List<Modelo> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);

        if(models.get(position) instanceof ModeloEmpleado){
            View view = layoutInflater.inflate(R.layout.item, container, false);
            ModeloEmpleado me = (ModeloEmpleado) models.get(position);
            ImageView imageView;
            TextView employerName, desc;

            imageView = view.findViewById(R.id.image);
            employerName = view.findViewById(R.id.employerName);
            desc = view.findViewById(R.id.desc);

            Glide.with(context).load(((ModeloEmpleado) models.get(position)).getImage())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imageView);
            employerName.setText(me.getEmpleadoName());
            desc.setText(me.getDesc());

            container.addView(view, 0);
            return view;
        }
        else{
            View view = layoutInflater.inflate(R.layout.status, container, false);
            ModeloStatus ms = (ModeloStatus) models.get(position);
            ImageView imageView;
            CardView cardView;
            cardView = view.findViewById(R.id.statusCard);
            imageView = view.findViewById(R.id.thumbs);
            if(ms.isLike()){
                imageView.setImageResource(R.drawable.tup);
            }
            else{
                imageView.setImageResource(R.drawable.tdown);
            }

            container.addView(view, 0);
            return view;
        }

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
