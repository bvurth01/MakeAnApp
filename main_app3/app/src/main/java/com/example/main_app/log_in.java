package com.example.main_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class log_in extends AppCompatActivity {
    FirebaseAuth auth;
    Button log_in, sign_up_btn;
    EditText username;
    EditText password_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        sign_up_btn = findViewById(R.id.sign_up);
        log_in = findViewById(R.id.save_button);
        username = findViewById(R.id.email);
        password_et = findViewById(R.id.password);
        log_in.setOnClickListener(this::onLogin);
        sign_up_btn.setOnClickListener(this::OnSignup);
    }
    public void onLogin(View v){
        if(username.getText().toString().trim().equals("")) {
            username.setError("you need to enter your email");
            return;
        }
        if(password_et.getText().toString().trim().equals("")) {
            password_et.setError("you need to enter your password");
            return;
        }
        auth.signInWithEmailAndPassword(username.getText().toString().trim(),password_et.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent main = new Intent(log_in.this, Main_page.class);
                    startActivity(main);
                }
                else Toast.makeText(log_in.this, "username does not exist", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void OnSignup(View v){
        Intent sig = new Intent(log_in.this, sign_up.class);
        startActivity(sig);
    }
}