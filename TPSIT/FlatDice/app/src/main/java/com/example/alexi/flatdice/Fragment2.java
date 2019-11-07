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

public class Fragment2 extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int num;
        Random n=new Random();

        num=n.nextInt(20)+1;

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
            case 7:
                view=inflater.inflate(R.layout.fragment_seven, container, false);
                break;
            case 8:
                view=inflater.inflate(R.layout.fragment_eight, container, false);
                break;
            case 9:
                view=inflater.inflate(R.layout.fragment_nine, container, false);
                break;
            case 10:
                view=inflater.inflate(R.layout.fragment_ten, container, false);
                break;
            case 11:
                view=inflater.inflate(R.layout.fragment_eleven, container, false);
                break;
            case 12:
                view=inflater.inflate(R.layout.fragment_twelve, container, false);
                break;
            case 13:
                view=inflater.inflate(R.layout.fragment_thirteen, container, false);
                break;
            case 14:
                view=inflater.inflate(R.layout.fragment_fourteen, container, false);
                break;
            case 15:
                view=inflater.inflate(R.layout.fragment_fifteen, container, false);
                break;
            case 16:
                view=inflater.inflate(R.layout.fragment_sixteen, container, false);
                break;
            case 17:
                view=inflater.inflate(R.layout.fragment_seventeen, container, false);
                break;
            case 18:
                view=inflater.inflate(R.layout.fragment_eighteen, container, false);
                break;
            case 19:
                view=inflater.inflate(R.layout.fragment_nineteen, container, false);
                break;
            case 20:
                view=inflater.inflate(R.layout.fragment_twenty, container, false);
                break;
        }
        // Inflate the layout for this fragment
        return view;
    }
}