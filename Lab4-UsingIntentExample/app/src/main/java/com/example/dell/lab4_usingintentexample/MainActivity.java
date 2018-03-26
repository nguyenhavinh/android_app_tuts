package com.example.dell.lab4_usingintentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupDoMathButton();
    }
    private void setupDoMathButton(){
        Button btn = (Button) findViewById(R.id.btn_myButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText userTextEntry  = (EditText) findViewById(R.id.edt_myEditText);
                String userData = userTextEntry.getText().toString();
                final int userNumber = Integer.parseInt(userData);
                Intent intent = new Intent(MainActivity.this, MathActivity.class);
                intent.putExtra("parameter name", userNumber);
                startActivity(intent);
            }
        });
    }

}
