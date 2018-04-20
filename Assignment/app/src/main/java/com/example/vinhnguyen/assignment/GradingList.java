package com.example.vinhnguyen.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GradingList extends AppCompatActivity {
    TextView hello;
    String examinerName, examinerId;
    DatabaseHelper myDb;
    String rankSelected;
    EditText current_rank;
    EditText dt2, dt3, dt4, dt5, dt6, dt8, dt9, dt10, dt11, dt12, dt13;
    Spinner dt7, dt14, dt15, dt16, dt17, dt18, dt19, dt20, dt21, dt22, dt23, dt24, dt25, dt26, dt27, dt28, dt29, dt30, dt31;
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
        //GET DATA
        dt2 = (EditText)findViewById(R.id.ed_name_value);
        dt3 = (EditText)findViewById(R.id.ed_club_branch_value);
        dt4 = (EditText)findViewById(R.id.ed_current_rank_value);
        dt5 = (EditText)findViewById(R.id.ed_home_phone_value);
        dt6 = (EditText)findViewById(R.id.ed_date_value);
        dt7 = (Spinner) findViewById(R.id.ed_gender_value);
        dt8 = (EditText)findViewById(R.id.ed_date_of_birth_value);
        dt9 = (EditText)findViewById(R.id.ed_age_value);
        dt10 = (EditText)findViewById(R.id.ed_weight_value);
        dt11 = (EditText)findViewById(R.id.ed_height_value);
        dt12 = (EditText)findViewById(R.id.ed_mobile_value);
        dt13 = (EditText)findViewById(R.id.ed_starting_time_value);
        dt14 = (Spinner)findViewById(R.id.ed_manner_value);
        dt15 = (Spinner)findViewById(R.id.ed_stances_value);
        dt16 = (Spinner)findViewById(R.id.ed_shorts_tances_value);
        dt17 = (Spinner)findViewById(R.id.ed_strikes_value);
        dt18 = (Spinner)findViewById(R.id.ed_strikes_new_value);
        dt19 = (Spinner)findViewById(R.id.ed_boxing_value);
        dt20 = (Spinner)findViewById(R.id.ed_blocks_value);
        dt21 = (Spinner)findViewById(R.id.ed_blocks_new_value);
        dt22 = (Spinner)findViewById(R.id.ed_kicks_value);
        dt23 = (Spinner)findViewById(R.id.ed_front_kick_value);
        dt24 = (Spinner)findViewById(R.id.ed_side_kick_value);
        dt25 = (Spinner)findViewById(R.id.ed_roundhouse_kick_value);
        dt26 = (Spinner)findViewById(R.id.ed_basic_value);
        dt27 = (Spinner)findViewById(R.id.ed_taeguk_value);
        dt28 = (Spinner)findViewById(R.id.ed_taeguk_new_value);
        dt29 = (Spinner)findViewById(R.id.ed_one_step_value);
        dt30 = (Spinner)findViewById(R.id.ed_sparring_value);
        dt31 = (Spinner)findViewById(R.id.ed_yell_value);
    }

    public void save(View view){
        boolean isInserted = myDb.insertStudent(dt2.getText().toString(), dt3.getText().toString(), dt4.getText().toString(), dt5.getText().toString(), dt6.getText().toString(),
                dt7.getSelectedItem().toString(), dt8.getText().toString(), dt9.getText().toString(), dt10.getText().toString(), dt11.getText().toString(), dt12.getText().toString(), dt13.getText().toString(),
                dt14.getSelectedItem().toString(), dt15.getSelectedItem().toString(), dt16.getSelectedItem().toString(), dt17.getSelectedItem().toString(), dt18.getSelectedItem().toString(), dt19.getSelectedItem().toString(),
                dt20.getSelectedItem().toString(), dt21.getSelectedItem().toString(), dt22.getSelectedItem().toString(), dt23.getSelectedItem().toString(), dt24.getSelectedItem().toString(), dt25.getSelectedItem().toString(),
                dt26.getSelectedItem().toString(), dt27.getSelectedItem().toString(), dt28.getSelectedItem().toString(), dt29.getSelectedItem().toString(), dt30.getSelectedItem().toString(), dt31.getSelectedItem().toString(), examinerId);
        if (isInserted == true){
            Toast.makeText(GradingList.this, "Student Data Inserted", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(GradingList.this, TimeTable.class);
            intent.putExtra("ExaminerId", examinerId);
            intent.putExtra("ExaminerName", examinerName);
            startActivity(intent);
        }
        else {
            Toast.makeText(GradingList.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
        }
    }
}
