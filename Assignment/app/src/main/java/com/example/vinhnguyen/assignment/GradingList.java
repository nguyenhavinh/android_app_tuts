package com.example.vinhnguyen.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;

public class GradingList extends AppCompatActivity {
    TextView hello;
    String examinerName, examinerId;
    DatabaseHelper myDb;
    String rankSelected;
    EditText current_rank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grading_list);
        myDb = new DatabaseHelper(this);
        current_rank = (EditText) findViewById(R.id.ed_current_rank_value);
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
        if (intent.hasExtra("Rank")){
            rankSelected = intent.getStringExtra("Rank");
        }
        else {
            rankSelected = "Value undefined";
        }
        String s = "Hello <b>" + examinerName.toUpperCase() + " with ID: " + examinerId + "</b>, please select the time table below";
        hello = (TextView) findViewById(R.id.tv_hello);
        hello.setText(Html.fromHtml(s));
        current_rank.setText(rankSelected);
    }

}
