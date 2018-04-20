package com.example.vinhnguyen.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentFeedback extends AppCompatActivity {
    TextView hello;
    String examinerName, examinerId;
    DatabaseHelper myDb;
    EditText studentID, posFeedback, negFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feedback);
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
        String s = "Hello <b>" + examinerName.toUpperCase() + " with ID: " + examinerId + "</b>, please select the time table below";
        hello = (TextView) findViewById(R.id.tv_hello);
        hello.setText(Html.fromHtml(s));

        studentID = (EditText)findViewById(R.id.ed_student_id_value);
        posFeedback = (EditText)findViewById(R.id.ed_positive_feedback_value);
        negFeedback = (EditText)findViewById(R.id.ed_negative_feedback_value);
    }

    public void loadFeedback(View view){
        String pos = "no feedback";
        String neg = "no feedback";
        Cursor res = myDb.loadFeedback(studentID.getText().toString());
        if (res.getCount() != 0) {
            if (res.moveToFirst()){
                pos = res.getString(2);
                neg = res.getString(3);
            }
        }
        displayFeedback(pos, neg);
    }

    public void saveFeedback(View view){
        boolean isSaved = myDb.updateFeedback(studentID.getText().toString(), posFeedback.getText().toString(), negFeedback.getText().toString());
        if (isSaved == true){
            Toast.makeText(StudentFeedback.this, "Feedback Saved", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(StudentFeedback.this, TimeTable.class);
            intent.putExtra("ExaminerId", examinerId);
            intent.putExtra("ExaminerName", examinerName);
            startActivity(intent);
        }
        else {
            Toast.makeText(StudentFeedback.this, "Feedback Not Saved", Toast.LENGTH_LONG).show();
        }
    }
    private void displayFeedback(final String a, final String b){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                posFeedback.setText(a);
                negFeedback.setText(b);
            }
        });
    }
}
