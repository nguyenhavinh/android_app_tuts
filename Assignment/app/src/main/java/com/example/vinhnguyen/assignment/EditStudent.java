package com.example.vinhnguyen.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditStudent extends AppCompatActivity {
    TextView hello;
    String examinerName, examinerId;
    DatabaseHelper myDb;
    EditText studentID;
    Spinner dt14, dt15, dt16, dt17, dt18, dt19, dt20, dt21, dt22, dt23, dt24, dt25, dt26, dt27, dt28, dt29, dt30, dt31;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        myDb = new DatabaseHelper(this);
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
        String s = "Hello <b>" + examinerName.toUpperCase() + " with ID: " + examinerId + "</b>, please chose the StudentID to edit/delete";
        hello = (TextView) findViewById(R.id.tv_hello);
        hello.setText(Html.fromHtml(s));
        studentID = (EditText)findViewById(R.id.ed_student_id_value);
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
    public void update (View view){
        boolean isUpdated = myDb.updateStudent(studentID.getText().toString(), dt14.getSelectedItem().toString(), dt15.getSelectedItem().toString(), dt16.getSelectedItem().toString(), dt17.getSelectedItem().toString(), dt18.getSelectedItem().toString(), dt19.getSelectedItem().toString(),
                dt20.getSelectedItem().toString(), dt21.getSelectedItem().toString(), dt22.getSelectedItem().toString(), dt23.getSelectedItem().toString(), dt24.getSelectedItem().toString(), dt25.getSelectedItem().toString(),
                dt26.getSelectedItem().toString(), dt27.getSelectedItem().toString(), dt28.getSelectedItem().toString(), dt29.getSelectedItem().toString(), dt30.getSelectedItem().toString(), dt31.getSelectedItem().toString());
        if (isUpdated== true){
            Toast.makeText(EditStudent.this, "Student Data Updated", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(EditStudent.this, TimeTable.class);
            intent.putExtra("ExaminerId", examinerId);
            intent.putExtra("ExaminerName", examinerName);
            startActivity(intent);
        }
        else {
            Toast.makeText(EditStudent.this, "Data Not Updated", Toast.LENGTH_LONG).show();
        }
    }
    public void delete (View view){
        Integer isDeleted = myDb.deleteStudent(studentID.getText().toString());
        if (isDeleted > 0){
            Toast.makeText(EditStudent.this, "Student Data Deleted", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(EditStudent.this, TimeTable.class);
            intent.putExtra("ExaminerId", examinerId);
            intent.putExtra("ExaminerName", examinerName);
            startActivity(intent);
        }
        else {
            Toast.makeText(EditStudent.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
        }
    }
}
