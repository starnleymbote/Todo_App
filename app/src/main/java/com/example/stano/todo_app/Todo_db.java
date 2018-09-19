package com.example.stano.todo_app;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.stano.todo_app.Daos.TodoDao;
import com.example.stano.todo_app.Daos.UserDao;
import com.example.stano.todo_app.Entities.Todo;
import com.example.stano.todo_app.Entities.User;


@Database(entities = {User.class,Todo.class}, version = 1)
public abstract class Todo_db extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract TodoDao todoDao();

    private static volatile Todo_db INSTANCE;


    static Todo_db getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Todo_db.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Todo_db.class, "tododb.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}