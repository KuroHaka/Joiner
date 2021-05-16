package com.example.joiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.startup_page);
        but = findViewById(R.id.initial_login_button);
        but.setOnClickListener(v -> login());

    }
    public void login() {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }
}