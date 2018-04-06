package com.example.dell.lab5_usingsqlitedatabase;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText edtId, edtName, edtSurName, edtMarks;
    Button btnAddData, btnViewALl, btnUpDate, btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        edtId = (EditText) findViewById(R.id.edt_id);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtSurName = (EditText) findViewById(R.id.edt_sureName);
        edtMarks = (EditText) findViewById(R.id.edt_marks);
        btnAddData = (Button) findViewById(R.id.btn_addData);
        btnViewALl = (Button) findViewById(R.id.btn_viewAll);
        btnUpDate = (Button) findViewById(R.id.btn_upDate);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        addData();
        viewAll();
        upDate();
        delete();
    }
    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isInserted = myDb.insertData(edtName.getText().toString(),
                                                            edtSurName.getText().toString(),
                                                            edtMarks.getText().toString());
                        if (isInserted == true){
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public void viewAll(){
        btnViewALl.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0){
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("Id : " + res.getString(0) + "\n");
                            buffer.append("Name : " + res.getString(1) + "\n");
                            buffer.append("Surname : " + res.getString(2) + "\n");
                            buffer.append("Marks : " + res.getString(3) + "\n");
                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }
    public void upDate(){
        btnUpDate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isUpDated = myDb.updateData(edtId.getText().toString(),
                                                            edtName.getText().toString(),
                                                            edtSurName.getText().toString(),
                                                            edtMarks.getText().toString());
                        if (isUpDated == true){
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public void delete(){
        btnDelete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Integer deletedRow = myDb.deleteData(edtId.getText().toString());
                        if (deletedRow > 0){
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
