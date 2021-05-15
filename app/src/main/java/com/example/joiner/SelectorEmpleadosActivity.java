package com.example.joiner;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.joiner.interfaz.AdapterEmpleado;
import com.example.joiner.interfaz.Modelo;
import com.example.joiner.interfaz.ModeloEmpleado;
import com.example.joiner.interfaz.ModeloStatus;

import java.util.ArrayList;
import java.util.List;

public class SelectorEmpleadosActivity extends AppCompatActivity {

    ViewPager viewPager;
    AdapterEmpleado adapter;
    List<Modelo> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.post);

        models = new ArrayList<>();
        models.add(new ModeloStatus(true));
        models.add(new ModeloEmpleado(R.drawable.fotoperfil, "Xoco", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
        models.add(new ModeloStatus(false));

        adapter = new AdapterEmpleado(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(160, 0, 160, 0);
        viewPager.setCurrentItem(1);

        Integer[] colors_temp = {
                getResources().getColor(R.color.colorGreen),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorRed)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
