package com.example.vinhnguyen.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TimeTable extends AppCompatActivity {
    TextView hello;
    String examinerName, examinerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        Intent intent = getIntent();
        if (intent.hasExtra("ExaminerName")){
            examinerName = intent.getStringExtra("ExaminerName");
        }
        else {
            examinerName = "Examiner name undefined";
        }
        if (intent.hasExtra("ExaminerId")){
            examinerId = intent.getStringExtra("ExaminerId");
        }
        else {
            examinerId = "Examiner ID undefined";
        }
        String s = "Hello <b>" + examinerName.toUpperCase() + " with ID: " + examinerId + "</b>, please select the time table below";
        hello = (TextView) findViewById(R.id.tv_hello);
        hello.setText(Html.fromHtml(s));

    }
}
