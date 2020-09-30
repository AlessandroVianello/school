package com.vianelloalessandro.iblogger_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class ProfileActivity2 extends AppCompatActivity {

    public static final String TAG = ProfileActivity2.class.getSimpleName();

    private ProfileFragment mProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            loadFragment();
        }
    }


    private void loadFragment(){

        if (mProfileFragment == null) {

            mProfileFragment = new ProfileFragment();
        }
        getFragmentManager().beginTransaction().replace(R.id.fragmentFrame, mProfileFragment,mProfileFragment.TAG).commit();
    }


}
