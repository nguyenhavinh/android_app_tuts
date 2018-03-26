package com.example.dell.lab4_eventhandlingsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    TextView myTextView;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView) findViewById(R.id.textView);
        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        myTextView.setText("Button clicked");
                    }
                }
        );
        myButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        myTextView.setText("Long Button Click");
                        return true;
                    }
                }
        );
    }
}
