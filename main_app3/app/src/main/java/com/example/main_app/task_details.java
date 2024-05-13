/*package com.example.main_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class task_details extends AppCompatActivity {
    EditText task_det_et , manager_det_et;
    Button save_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        task_det_et = findViewById(R.id.task_det);
        manager_det_et = findViewById(R.id.manager_det);
        save_btn = findViewById(R.id.go_back);
        save_btn.setOnClickListener(this::Onsave);
    }
    public void Onsave(View v){
        String tn = task_det_et.getText().toString();
        String mn = manager_det_et.getText().toString();
        Intent goBack = new Intent();
        goBack.putExtra("task name",tn);
        goBack.putExtra("manager name", mn);
        startActivity(goBack);
    }
}*/
package com.example.main_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class task_details extends AppCompatActivity {
    EditText task_det_et, manager_det_et;
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        task_det_et = findViewById(R.id.task_det);
        manager_det_et = findViewById(R.id.manager_det);
        save_btn = findViewById(R.id.go_back);
        save_btn.setOnClickListener(this::onSaveClicked);
    }

    public void onSaveClicked(View v) {
        String tn = task_det_et.getText().toString();
        String mn = manager_det_et.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("task name", tn);
        resultIntent.putExtra("manager name", mn);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}

