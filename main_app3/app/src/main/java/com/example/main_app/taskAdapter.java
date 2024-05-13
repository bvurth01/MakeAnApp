package com.example.main_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class taskAdapter extends ArrayAdapter <task> {
    Context context;
    List <task> list;

    public taskAdapter(Context context,int resource,int textViewResourceId, List<task> list) {
        super(context,resource,textViewResourceId,list);
        this.context = context;
        this.list = list;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
        View body = layoutInflater.inflate(R.layout.body,parent,false);
        TextView task_name = body.findViewById(R.id.task_name);
        TextView date = body.findViewById(R.id.date);
        ProgressBar progressBar = body.findViewById(R.id.progressBar);
        TextView manager_name = body.findViewById(R.id.manage_nm);
        task temp = list.get(position);
        task_name.setText(temp.getTask_name());
        date.setText(String.valueOf(temp.get_Date()));
        progressBar.setProgress(temp.getTask_percentage());
        manager_name.setText(temp.getManager());
        return body;
    }
}