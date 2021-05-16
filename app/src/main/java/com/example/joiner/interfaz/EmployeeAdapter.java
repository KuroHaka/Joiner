package com.example.joiner.interfaz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.joiner.R;
import com.example.joiner.TodoActivity;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

    Context c;
    ArrayList<String> names;

    public EmployeeAdapter(Context c, ArrayList<String> names) {
        this.c = c;
        this.names = names;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_search_row, null);
        return new EmployeeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int i) {
        holder.setText(names.get(i));
        holder.getLl().setOnClickListener(view -> {
            Intent intent = new Intent (c, TodoActivity.class);
            c.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}
