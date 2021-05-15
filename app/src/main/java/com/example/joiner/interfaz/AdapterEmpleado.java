package com.example.joiner.interfaz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.joiner.R;

import java.util.List;

public class AdapterEmpleado extends PagerAdapter {

    private List<ModeloEmpleado> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterEmpleado(List<ModeloEmpleado> models, Context context) {
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
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView employerName, desc;

        imageView = view.findViewById(R.id.image);
        employerName = view.findViewById(R.id.employerName);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        employerName.setText(models.get(position).getEmpleadoName());
        desc.setText(models.get(position).getDesc());


        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
