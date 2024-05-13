package com.example.main_app;

import java.util.ArrayList;
import java.util.Date;

public class task {
    String manager;
    ArrayList<String> members;
    int sum_of_members;
    String task_name;
    int task_percentage;
    Date date;

    public task(String manager, ArrayList<String> members, String task_name) {
        this.manager = manager;
        if(members == null) {
            this.members = new ArrayList<>();
            this.sum_of_members = 0;
        } else {
            this.members = new ArrayList<>(members);
            this.sum_of_members = members.size();
        }
        this.task_name = task_name;
        this.task_percentage = 0;
        this.date = new Date();
    }

    public Date get_Date(){
        return date;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public int getSum_of_members() {
        return sum_of_members;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public int getTask_percentage() {
        return task_percentage;
    }

    public void setTask_percentage(int task_percentage) {
        this.task_percentage = task_percentage;
    }
    public void Addmember (String member) {
        this.members.add(member);
        this.sum_of_members++;
    }
}