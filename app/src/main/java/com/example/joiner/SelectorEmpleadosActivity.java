package com.example.joiner;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.joiner.dataGenerator.DataGen;
import com.example.joiner.interfaz.AdapterEmpleado;
import com.example.joiner.interfaz.Modelo;
import com.example.joiner.interfaz.ModeloEmpleado;
import com.example.joiner.interfaz.ModeloStatus;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class SelectorEmpleadosActivity extends AppCompatActivity {

    ViewPager viewPager;
    AdapterEmpleado adapter;
    List<Modelo> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.post);

        models = new ArrayList<>();
        Faker faker = new Faker();
        String name = faker.name().fullName();

        String desc = "";
        DataGen dg = new DataGen();

        if (getIntent().getStringExtra("val").equals("Programmer")){
            desc = dg.getLanguages() + "\n\n" + dg.getTechCompanies() + "\n\n"+ dg.getCode() + "\n\n" +
                dg.getStudies();
        }
        else if (getIntent().getStringExtra("val").equals("Waiter")){
            desc = dg.getLanguages() + "\n\n" + dg.getAsistanceCompanies() + "\n\n" +
                    dg.getStudies();
        }
        else if (getIntent().getStringExtra("val").equals("Musician")){
            desc = dg.getLanguages() + "\n\n" + dg.getMusicStyle() + "\n\n"  + dg.getInstruments() + "\n\n" +
                    dg.getStudies();
        }
        else{
            desc = dg.getLanguages() + "\n\n" + dg.getCompanies() + "\n\n"  + dg.getEditorPrograms() + "\n\n" +
                    dg.getStudies();
        }



        models.add(new ModeloStatus(true));
        models.add(new ModeloEmpleado("https://thispersondoesnotexist.com/image", name, desc));
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
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    nextPost();
                    viewPager.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fadeout));
                }
                else if (position == 2){
                    nextPost();
                    viewPager.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fadeout));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void nextPost(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(context, SelectorEmpleadosActivity.class);
                intent.putExtra("val",getIntent().getStringExtra("val"));
                startActivity(intent);
                finish();
            }
        },500);
    }


}
