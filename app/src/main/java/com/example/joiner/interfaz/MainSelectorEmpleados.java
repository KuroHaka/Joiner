package com.example.joiner.interfaz;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.joiner.R;

import java.util.ArrayList;
import java.util.List;

public class MainSelectorEmpleados  extends AppCompatActivity {

    ViewPager viewPager;
    AdapterEmpleado adapter;
    List<ModeloEmpleado> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        models = new ArrayList<>();
        models.add(new ModeloEmpleado(R.drawable.fotoperfil, "Eugenio", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new ModeloEmpleado(R.drawable.fotoperfil, "Max", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new ModeloEmpleado(R.drawable.fotoperfil, "Xoco", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
        models.add(new ModeloEmpleado(R.drawable.fotoperfil, "Mico", "Business cards are cards bearing business information about a company or individual."));

        adapter = new AdapterEmpleado(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

    }
}
