package com.example.dell.lab3_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    Boolean mAnswer = false;
    private static RadioGroup radio_g;
    private static RadioButton radio_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio_g = (RadioGroup) findViewById(R.id.radioGroup);
        mButton = (Button) findViewById(R.id.bt_submit);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int selected_id = radio_g.getCheckedRadioButtonId();
                radio_b = (RadioButton) findViewById(selected_id);

                if (radio_b.getId() == R.id.bt_third){
                    Toast.makeText(getApplicationContext(), "This is correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Unfortunately, this is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
