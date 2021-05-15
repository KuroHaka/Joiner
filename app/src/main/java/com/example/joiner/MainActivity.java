package com.example.joiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.startup_page);


        but = findViewById(R.id.initial_login_button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity2();
            }
        });

    }
    public void activity2() {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }
}