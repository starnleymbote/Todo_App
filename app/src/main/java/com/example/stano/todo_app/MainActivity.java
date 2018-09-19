package com.example.stano.todo_app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stano.todo_app.Entities.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    TextView txtuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        txtuser = findViewById(R.id.user);

        getData();


    }
    public void getData()
    {
        final String[] theusers = {"\n"};
        Todo_db.getDatabase(context).userDao().getAllUsers().observe((LifecycleOwner) context,
                new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                for (User user:users) {

                    theusers[0] += theusers[0] +"Id "+user.getId()+"\n Name "+user.getUser_name()+"\n";
                }

                txtuser.setText(theusers[0]);
                Toast.makeText(context,"Users "+users+" size "+users.size(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void insert()
    {
        new Thread()
        {
            @Override
            public void run() {
                Todo_db.getDatabase(context)
                        .userDao()
                        .insert(new User(
                                2,
                                "Stano"
                        ));
                Todo_db.getDatabase(context)
                        .userDao()
                        .insert(new User(
                                3,
                                "Nix"
                        ));

            }
        }.start();
    }
}
