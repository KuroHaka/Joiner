package com.example.joiner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.startup_page);

        /*TextView tV = findViewById(R.id.sign_up_txt);
        String s_up_txt = "Sign Up";
        SpannableString ss = new SpannableString(s_up_txt);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        tV.setText(ss);*/
    }
}