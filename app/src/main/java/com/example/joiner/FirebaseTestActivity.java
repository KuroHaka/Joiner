package com.example.joiner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class FirebaseTestActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db.collection("log_in_info")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            System.out.println(document.get("Usuario"));
                        }
                    }
                    else {
                    }
                });


        setContentView(R.layout.startup_page);

        but = findViewById(R.id.initial_login_button);
        but.setOnClickListener(v -> login());

    }
    public void login() {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }
}