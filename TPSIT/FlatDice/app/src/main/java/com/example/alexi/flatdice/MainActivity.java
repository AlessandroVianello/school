package com.example.alexi.flatdice;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float x1,x2,y1,y2;
    final static float MIN_DISTANCE = 150.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment) != null){
            Fragment1 f1 = new Fragment1();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, f1);
            ft.commit();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                float deltaX = x2 - x1;
                float deltaY = y2 - y1;

                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    if (x2 > x1) {
                        changeFragmentLeft_Right();
                    }

                    else {
                        changeFragmentLeft_Right();
                    }
                }

                if (Math.abs(deltaY) > MIN_DISTANCE) {
                    if (y2 > y1) {
                        changeFragmentUp_Down();
                    }

                    else {
                        changeFragmentUp_Down();
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void changeFragmentLeft_Right() {
        if(findViewById(R.id.fragment) != null){
            FragmentManager fm = getFragmentManager();
            Fragment nextFragment = null;
            Fragment currentFragment = fm.findFragmentById(R.id.fragment);
            if (currentFragment instanceof Fragment1) {
                nextFragment = new Fragment2();
            } else {
                nextFragment = new Fragment1();
            }
            FragmentTransaction ft = fm.beginTransaction();
            // (enter, exit)
            if(x2>x1)
                ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
            else
                ft.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
            ft.replace(R.id.fragment, nextFragment);
            ft.commit();
        } else {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show ();
        }

    }

    public void changeFragmentUp_Down() {
        if(findViewById(R.id.fragment) != null){
            FragmentManager fm = getFragmentManager();
            Fragment nextFragment = null;
            Fragment currentFragment = fm.findFragmentById(R.id.fragment);
            if (currentFragment instanceof Fragment1) {
                nextFragment = new Fragment2();
            } else {
                nextFragment = new Fragment1();
            }
            FragmentTransaction ft = fm.beginTransaction();
            // (enter, exit)
            if(y2>y1)
                ft.setCustomAnimations(R.animator.slide_in_down, R.animator.slide_out_up);
            else
                ft.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_down);
            ft.replace(R.id.fragment, nextFragment);
            ft.commit();
        } else {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show ();
        }

    }
}