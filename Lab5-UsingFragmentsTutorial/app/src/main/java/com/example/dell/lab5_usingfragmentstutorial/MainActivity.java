package com.example.dell.lab5_usingfragmentstutorial;

//import android.app.Fragment;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    public ViewGroup mContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer = (ViewGroup)findViewById(R.id.fragment);
        mContainer.setBackgroundColor(Color.WHITE);
    }

    public void selectFrag(View view) {
        android.support.v4.app.Fragment fr;
        int mColor;
        if (view == findViewById(R.id.button1)){
            fr = new FragmentOne();
            mColor = Color.BLUE;
        }
        else {
            fr = new FragmentTwo();
            mColor = Color.RED;
        }

        mContainer.removeAllViews();

        mContainer.setBackgroundColor(mColor);
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(mContainer.getId(), fr);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
