package com.example.joiner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class LoginPageActivity extends AppCompatActivity {
    private TextView tV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        tV = findViewById(R.id.sign_up_txt);
        tV.setMovementMethod(LinkMovementMethod.getInstance());
    }
}