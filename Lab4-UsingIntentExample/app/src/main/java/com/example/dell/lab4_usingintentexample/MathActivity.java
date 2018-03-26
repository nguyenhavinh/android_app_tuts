package com.example.dell.lab4_usingintentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        Intent intent = getIntent();
        if (intent.hasExtra("parameter name")){
            int myValue = intent.getIntExtra("parameter name", 0);

            TextView displayNumber = (TextView) findViewById(R.id.tv_mathTextView);
            displayNumber.setText(Integer.toString(myValue));
        }
        else {
            TextView displayNumber = (TextView) findViewById(R.id.tv_mathTextView);
            displayNumber.setText("No Value");
        }

    }

}
