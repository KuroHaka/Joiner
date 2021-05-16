package com.example.joiner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.joiner.interfaz.JobAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeActivitie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_home);
        RecyclerView rv = findViewById(R.id.employrecycle);
        rv.setLayoutManager(new LinearLayoutManager(this));

        EmployeeAdapter ja = new JobAdapter(this, getEmployee());
        rv.setAdapter(ja);

        FloatingActionButton fb =  findViewById(R.id.employadd);
        fb.setOnClickListener(view -> addEmployee());
    }
    private ArrayList<String> getEmployee() {
        return new ArrayList<>(Arrays.asList("Laura from : Java", "Elise from : Google", "Connie from : Bandai", "John from : Cocacola"));
    }

    private void addEmployee(){
        //TODO
        //Empezar cuestionario
    }
}
