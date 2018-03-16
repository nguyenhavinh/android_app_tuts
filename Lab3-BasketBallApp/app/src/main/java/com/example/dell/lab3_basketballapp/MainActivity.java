package com.example.dell.lab3_basketballapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int sumA = 0;
    TextView A_total_point;
    Button A_3p;
    Button A_2p;
    Button A_1p;
    private void displayPoint(final int point){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                A_total_point.setText(Integer.toString(point));
            }
        });
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_A_3:{
                sumA = sumA+3;
                displayPoint(sumA);
                break;
            }
            case R.id.bt_A_2:{
                sumA = sumA +2;
                displayPoint(sumA);
                break;
            }
            case R.id.bt_A_1:{
                sumA = sumA +1;
                displayPoint(sumA);
                break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        A_total_point = (TextView) findViewById(R.id.tv_teamA_score);
        A_3p = (Button) findViewById(R.id.bt_A_3);
        A_3p.setOnClickListener(this);
        A_2p = (Button) findViewById(R.id.bt_A_2);
        A_2p.setOnClickListener(this);
        A_1p = (Button) findViewById(R.id.bt_A_1);
        A_1p.setOnClickListener(this);
        A_total_point.setText(Integer.toString(sumA));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_reset){
            sumA = 0;
            displayPoint(sumA);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

