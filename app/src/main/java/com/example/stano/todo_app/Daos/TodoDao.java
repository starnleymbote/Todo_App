package com.example.stano.todo_app.Daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.stano.todo_app.Entities.Todo;
import com.example.stano.todo_app.Entities.User;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    void insert(Todo todo);

    @Query("DELETE FROM Todo")
    void deleteAll();

    @Query("SELECT * from Todo ORDER BY id ASC")
    LiveData<List<User>> getAllTodos();
}
