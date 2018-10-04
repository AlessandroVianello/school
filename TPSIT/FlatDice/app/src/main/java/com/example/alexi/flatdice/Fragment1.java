package com.example.alexi.flatdice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

/**
 * Created by alexi on 07/03/2018.
 */

public class Fragment1 extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       int num;
        Random n=new Random();

        num=n.nextInt(6)+1;

        switch (num){
            case 1:
                view=inflater.inflate(R.layout.fragment_one, container, false);
                break;
            case 2:
                view=inflater.inflate(R.layout.fragment_two, container, false);
                break;
            case 3:
                view=inflater.inflate(R.layout.fragment_three, container, false);
                break;
            case 4:
                view=inflater.inflate(R.layout.fragment_four, container, false);
                break;
            case 5:
                view=inflater.inflate(R.layout.fragment_five, container, false);
                break;
            case 6:
                view=inflater.inflate(R.layout.fragment_six, container, false);
                break;
        }
        // Inflate the layout for this fragment
        return view;
    }
}