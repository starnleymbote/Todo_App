package com.example.stano.todo_app.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Todo {
    @PrimaryKey
    int id;
    int status;
    String user_name;

    public Todo() {
    }

    public Todo(int id, int status, String user_name) {
        this.id = id;
        this.status = status;
        this.user_name = user_name;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
