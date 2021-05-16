package com.example.joiner.interfaz;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.joiner.R;

public class EmployeeHolder extends RecyclerView.ViewHolder {
    TextView tv;
    RelativeLayout ll;

    public void setText(String s) {
        tv.setText(s);
    }

    public RelativeLayout getLl() {
        return ll;
    }

    public EmployeeHolder(View itemView) {
        super(itemView);
        this.tv = itemView.findViewById(R.id.employeeTxt);
        this.ll = itemView.findViewById(R.id.employeeLay);
    }
}
