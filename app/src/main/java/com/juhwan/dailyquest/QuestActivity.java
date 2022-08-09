package com.juhwan.dailyquest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestActivity extends AppCompatActivity {

    private Button addButton;
    private ListView container;

    ScheduleAdapter adapter = new ScheduleAdapter();

    int i=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        addButton = (Button) findViewById(R.id.addButton);
        container = (ListView) findViewById(R.id.schedule);

        container.setAdapter(adapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSchedule();


            }
        });
    }

    public void addSchedule() {
        adapter.addItem("제목", i, i);
        adapter.notifyDataSetChanged();
    }

}