package com.example.main_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_page extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    Scanner in = new Scanner(System.in);
    ListView listView;
    public static taskAdapter taskAdapter;
    public static ArrayList<task> attempt;
    Button newStartup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        newStartup = findViewById(R.id.new_project);
        newStartup.setOnClickListener(this::OnNewStartup);
        Intent intent = getIntent();
        listView = findViewById(R.id.main_list);
        attempt = new ArrayList<>();
        taskAdapter = new taskAdapter(this, 0, 0, attempt);
        listView.setAdapter(taskAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

   /* public void OnNewStartup(View v, Intent data) {
        Intent details = new Intent(Main_page.this, task_details.class);
        startActivity(details);
        String tn = data.getStringExtra("task name");
        String mn = data.getStringExtra("manager name");
        attempt.add(new task(mn, null, tn));
        taskAdapter.notifyDataSetChanged();
        //add intent to another activity
    }*/

    public void OnItemLongclick(View v){
        Intent info = new Intent(Main_page.this , project_info.class);
        startActivity(info);
    }

    public void ProjectOnclick(View v){
        Intent info = new Intent(Main_page.this, project_info.class);
        startActivity(info);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DialogFragment deleteDialog = new delete_dialog(position);
        deleteDialog.show(getSupportFragmentManager(), "deleteDialog");
    }

    public void OnNewStartup(View v) {
        Intent details = new Intent(Main_page.this, task_details.class);
        startActivityForResult(details, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String tn = data.getStringExtra("task name");
                String mn = data.getStringExtra("manager name");
                attempt.add(new task(mn, null, tn));
                taskAdapter.notifyDataSetChanged();
            }
        }
    }

    public void removeItem(int position) {
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}