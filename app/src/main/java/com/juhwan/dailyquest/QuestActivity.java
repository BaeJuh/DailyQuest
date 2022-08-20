package com.juhwan.dailyquest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestActivity extends AppCompatActivity {

    private Button addButton;
    private ListView container;

    private LinearLayout dialog;
    private EditText Edit_schedule;
    private EditText Edit_hour;
    private EditText Edit_minute;
    private TextView caution;

    String s = "";
    int h = 0;
    int m = 0;
    boolean isNum = true;

    ScheduleAdapter adapter = new ScheduleAdapter();

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
                show_dialog();
            }
        });
    }

    public void addSchedule(String s ,int h, int m) {
        adapter.addItem(s, h, m);
        adapter.notifyDataSetChanged();
    }

    public void show_dialog() {
        dialog= (LinearLayout) View.inflate(QuestActivity.this, R.layout.dialog, null);
        Edit_schedule=(EditText) dialog.findViewById(R.id.Edit_schedule);
        Edit_hour=(EditText) dialog.findViewById(R.id.Edit_hour);
        Edit_minute=(EditText) dialog.findViewById(R.id.Edit_minute);
        caution=(TextView) dialog.findViewById(R.id.caution);

        AlertDialog.Builder dig = new AlertDialog.Builder(QuestActivity.this);
        dig.setTitle("시간 입력");
        dig.setView(dialog);

        if (!isNum) {
            caution.setText("숫자를 제대로 입력하세요.");
        }

        dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                s = Edit_schedule.getText().toString();

                try {
                    h = Integer.parseInt(Edit_hour.getText().toString().trim());
                    m = Integer.parseInt(Edit_minute.getText().toString().trim());
                    addSchedule(s, h, m);
                    isNum = true;
                } catch (NumberFormatException e) {
                    isNum = false;
                    show_dialog();
                }
            }
        });

        dig.setNegativeButton("취소", null);
        dig.show();
    }

}