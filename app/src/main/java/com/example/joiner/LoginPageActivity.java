package com.example.joiner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPageActivity extends AppCompatActivity {
    private TextView signup_text;
    private TextView usr_email, usr_pswd;
    private Button sign_in_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        signup_text = findViewById(R.id.sign_up_txt);
        signup_text.setClickable(true);
        signup_text.setMovementMethod(LinkMovementMethod.getInstance());

        usr_email = findViewById(R.id.email);
        usr_pswd = findViewById(R.id.password);
        sign_in_btn = findViewById(R.id.sign_in_btn);

        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login() {
            Intent intent = new Intent(this, RRHHActivity.class);
            startActivity(intent);
    }

}