package com.example.joiner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;


public class LoginPageActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Long id;
    private Boolean authenticated = false;;
    private String username;
    private Map<String,Object> informacion;
    private TextView usr_email, usr_pswd;
    private Button sign_in_btn, sign_up_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        sign_up_btn = findViewById(R.id.sign_up_btn);

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign_up();
            }
        });

        usr_email = findViewById(R.id.email);
        usr_pswd = findViewById(R.id.password);
        sign_in_btn = findViewById(R.id.sign_in_btn);

        sign_in_btn.setOnClickListener(v -> login());

    }
    public void login() {
        db.collection("log_in_info")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String email = (String)document.get("email");
                            String password = (String)document.get("password");
                            if (email.equals(usr_email.getText().toString()) && password.equals(usr_pswd.getText().toString())){
                                authenticated = true;

                                username = (String)document.get("Usuario");
                                id = (Long)document.get("id");
                            }
                            //System.out.println(authenticated);

                        }
                    }
                });
        System.out.println(authenticated);
        if (authenticated){
            authenticated = false;
            db.collection("rrhh_aptitudes")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            boolean change = true;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (id.equals((Long) document.get("id"))){
                                    changeActivitie(true);
                                    change = false;
                                }
                            }
                            if(change){
                                changeActivitie(false);
                            }
                        }
                    });
        }

    }
    private void changeActivitie(boolean b){
        Intent intent;
        if(b){
            intent = new Intent(this, RRHHActivity.class);
        }
        else{
            intent = new Intent(this, EmployeeActivitie.class);
        }
        intent.putExtra("id", id);
        startActivity(intent);
    }


    public void sign_up() {
        Intent intent = new Intent(this, WebViewActivity.class);
        startActivity(intent);
    }

}