package com.example.joiner;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.joiner.dataGenerator.DataGen;
import com.example.joiner.interfaz.AdapterEmpleado;
import com.example.joiner.interfaz.Modelo;
import com.example.joiner.interfaz.ModeloEmpleado;
import com.example.joiner.interfaz.ModeloStatus;
import com.github.javafaker.Faker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SelectorEmpleadosActivity extends AppCompatActivity {
    Map<String,Object> data;
    String docId;
    boolean modified;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ViewPager viewPager;
    Random r = new Random();
    AdapterEmpleado adapter;
    List<Modelo> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Context context = this;
    Long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.post);


        this.id = getIntent().getLongExtra("id",-1);
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
                    db.collection("rrhh_aptitudes")
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    boolean change = true;
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        if (id.equals((Long) document.get("id"))){
                                            docId = document.getId();
                                            data = (Map<String,Object>)document.getData().get("tags");
                                            modifygood();
                                        }
                                    }
                                }
                            });
                    nextPost();
                    viewPager.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fadeout));
                    }

                else if (position == 2){
                    db.collection("rrhh_aptitudes")
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    boolean change = true;
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        if (id.equals((Long) document.get("id"))){
                                            docId = document.getId();
                                            data = (Map<String,Object>)document.getData().get("tags");
                                            modifybad();
                                        }
                                    }
                                }
                            });
                    nextPost();
                    viewPager.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fadeout));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void modifygood(){
        int p = r.nextInt(3);
        if (p == 0) {
            data.put("competent", ((Long) data.get("competent")) + 1);
        } else if (p == 1) {
            data.put("health", ((Long) data.get("health")) + 1);
        } else {
            data.put("party", ((Long) data.get("party")) + 1);
        }
        Map<String, Object> mp = new HashMap<>();
        mp.put("id", id);
        mp.put("tags", data);
        db.collection("rrhh_aptitudes").document(docId)
                .set(mp)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }
    public void modifybad(){
        int p = r.nextInt(3);
        if(p == 0){
            data.put("competent", ((Long)data.get("competent"))-1);
        }
        else if(p==1){
            data.put("health", ((Long)data.get("health"))-1);
        }
        else{
            data.put("party", ((Long)data.get("party"))-1);
        }
        Map<String, Object> mp = new HashMap<>() ;
        mp.put("id",id);
        mp.put("tags",data);
        db.collection("rrhh_aptitudes").document(docId)
                .set(mp)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

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
        },300);
    }


}
