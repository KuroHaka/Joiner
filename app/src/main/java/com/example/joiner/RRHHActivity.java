package com.example.joiner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.joiner.interfaz.JobAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;

public class RRHHActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rrhh_home);
        RecyclerView rv = findViewById(R.id.jobrecycle);
        rv.setLayoutManager(new LinearLayoutManager(this));

        JobAdapter ja = new JobAdapter(this, getJobs(),getIntent().getLongExtra("id",-1));
        rv.setAdapter(ja);

        FloatingActionButton fb =  findViewById(R.id.jobadd);
        fb.setOnClickListener(view -> addJob());

    }

    private ArrayList<String> getJobs() {
        return new ArrayList<>(Arrays.asList("Programmer", "Waiter", "Musician", "3D Artist"));
    }

    private void addJob(){
        Intent intent = new Intent(this, TodoActivity.class);
        startActivity(intent);
    }
}


