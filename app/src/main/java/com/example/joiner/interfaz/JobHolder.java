package com.example.joiner.interfaz;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.joiner.R;

public class JobHolder extends RecyclerView.ViewHolder {
    TextView tv;
    RelativeLayout ll;

    public void setText(String s) {
        tv.setText(s);
    }

    public RelativeLayout getLl() {
        return ll;
    }

    public JobHolder(View itemView) {
        super(itemView);
        this.tv = itemView.findViewById(R.id.jobTxt);
        this.ll = itemView.findViewById(R.id.jobLay);

    }
}
