package com.example.joiner.interfaz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.joiner.R;
import com.example.joiner.SelectorEmpleadosActivity;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobHolder> {

    Context c;
    ArrayList<String> names;
    Long id;

    public JobAdapter(Context c, ArrayList<String> names, Long id) {
        this.c = c;
        this.names = names;
        this.id = id;
    }

    @NonNull
    @Override
    public JobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_search_row, null);
        return new JobHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JobHolder holder, int i) {
        holder.setText(names.get(i));
        holder.getLl().setOnClickListener(view -> {
            Intent intent = new Intent (c, SelectorEmpleadosActivity.class);
            intent.putExtra("id", this.id);
            intent.putExtra("val",names.get(i));
            c.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}
