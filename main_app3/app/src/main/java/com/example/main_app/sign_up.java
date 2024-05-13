package com.example.main_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class sign_up extends AppCompatActivity implements View.OnClickListener {
    EditText email;
    EditText password;
    Button save_btn;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore ff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email=findViewById(R.id.re_email);
        password=findViewById(R.id.re_password);

        save_btn = findViewById(R.id.save);
        save_btn.setOnClickListener(this::onClick);
        ff = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        String str_email = email.getText().toString().trim();
        String str_password = password.getText().toString().trim();
        firebaseAuth.createUserWithEmailAndPassword(str_email, str_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String,Object> data = new HashMap<>();
                    data.put("email",str_email);
                    data.put("password",str_password);

                    ff.collection("users").document(firebaseAuth.getCurrentUser().getUid()).set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(sign_up.this, "user have been saved!", Toast.LENGTH_SHORT).show();
                            Intent back = new Intent(sign_up.this, log_in.class);
                            startActivity(back);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(sign_up.this, "something went worng please try again later", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(sign_up.this, "something went worng please try again later", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}