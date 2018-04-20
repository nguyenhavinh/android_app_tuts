package com.example.vinhnguyen.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.TextView;

public class TimeTable extends AppCompatActivity implements View.OnClickListener {
    TextView hello;
    String examinerName, examinerId;
    DatabaseHelper myDb;
    String rankSelected;
    TextView white_belt_id, yellow_belt1_id, yellow_belt2_id, yellow_belt3_id;
    TextView blue_belt1_id, blue_belt2_id, blue_belt3_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        myDb = new DatabaseHelper(this);

        white_belt_id = (TextView) findViewById(R.id.tv_white_belt_name);
        white_belt_id.setOnClickListener(this);
        yellow_belt1_id = (TextView) findViewById(R.id.tv_yellow_belt1_name);
        yellow_belt1_id.setOnClickListener(this);
        yellow_belt2_id = (TextView) findViewById(R.id.tv_yellow_belt2_name);
        yellow_belt2_id.setOnClickListener(this);
        yellow_belt3_id = (TextView) findViewById(R.id.tv_yellow_belt3_name);
        yellow_belt3_id.setOnClickListener(this);

        blue_belt1_id = (TextView) findViewById(R.id.tv_blue_belt1_name);
        blue_belt1_id.setOnClickListener(this);
        blue_belt2_id = (TextView) findViewById(R.id.tv_blue_belt2_name);
        blue_belt2_id.setOnClickListener(this);
        blue_belt3_id = (TextView) findViewById(R.id.tv_blue_belt3_name);
        blue_belt3_id.setOnClickListener(this);

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

    @Override
    public void onClick (View view){
        switch (view.getId()) {
            case R.id.tv_white_belt_name:
                rankSelected = white_belt_id.getText().toString();
                moveToInputForm(rankSelected);
                break;
            case R.id.tv_yellow_belt1_name:
                rankSelected = yellow_belt1_id.getText().toString();
                moveToInputForm(rankSelected);
                break;
            case R.id.tv_yellow_belt2_name:
                rankSelected = yellow_belt2_id.getText().toString();
                moveToInputForm(rankSelected);
                break;
            case R.id.tv_yellow_belt3_name:
                rankSelected = yellow_belt3_id.getText().toString();
                moveToInputForm(rankSelected);
                break;
            case R.id.tv_blue_belt1_name:
                rankSelected = blue_belt1_id.getText().toString();
                moveToInputForm(rankSelected);
                break;
            case R.id.tv_blue_belt2_name:
                rankSelected = blue_belt2_id.getText().toString();
                moveToInputForm(rankSelected);
                break;
            case R.id.tv_blue_belt3_name:
                rankSelected = blue_belt3_id.getText().toString();
                moveToInputForm(rankSelected);
                break;
            default:
                moveToInputForm(rankSelected);
        }
    }

    public void editStudent(View view){
        Intent intent = new Intent(TimeTable.this, EditStudent.class);
        intent.putExtra("ExaminerId", examinerId);
        intent.putExtra("ExaminerName", examinerName);
        startActivity(intent);
        return;
    }
    public void viewStudents(View view){
        Cursor res = myDb.viewStudents(examinerId);
        if (res.getCount() == 0){
            showMessage("Error", "No Student Records Found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID: " + res.getString(0) + "\n");
            buffer.append("NAME: " + res.getString(1) + "\n");
            buffer.append("TOTAL: " + res.getString(31) + "\n");
        }
        showMessage("Students Data", buffer.toString());
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void moveToInputForm(String rank){
        Intent intent = new Intent(TimeTable.this, GradingList.class);
        intent.putExtra("ExaminerId", examinerId);
        intent.putExtra("ExaminerName", examinerName);
        intent.putExtra("Rank", rankSelected);
        startActivity(intent);
    }
}
