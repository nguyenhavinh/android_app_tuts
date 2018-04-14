package com.example.vinhnguyen.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button btn_register, btn_login;
    EditText ed_username, ed_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btn_register = (Button) findViewById(R.id.btn_register);
        //btn_login = (Button) findViewById(R.id.btn_login);
        ed_username = (EditText) findViewById(R.id.ed_username);
        ed_password = (EditText) findViewById(R.id.ed_password);

        myDB = new DatabaseHelper(this);
    }
    public void register(View view){
        Log.i("Main activity", "button register clicked");
        boolean isInserted = myDB.insertExaminer(ed_username.getText().toString(), ed_password.getText().toString());
        if (isInserted == true){
            Toast.makeText(MainActivity.this, "New Examiner Inserted", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "New Examiner Not Inserted", Toast.LENGTH_LONG).show();
        }
    }
    public void login(View view){
        Log.i("Main activity", "button login clicked");
        Cursor res = myDB.loginExaminer(ed_username.getText().toString(), ed_password.getText().toString());
        if (res.getCount() == 0){
            Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            String arrData[] = new String[res.getColumnCount()];
            if (res.moveToFirst()){
                arrData[0] = res.getString(0);
                arrData[1] = res.getString(1);
                arrData[2] = res.getString(2);
            }
            Toast.makeText(MainActivity.this, "Welcome, "+ arrData[1] + " You are login", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, TimeTable.class);
            intent.putExtra("ExaminerId", arrData[0]);
            intent.putExtra("ExaminerName", arrData[1]);
            startActivity(intent);
            return;
        }
    }
}
