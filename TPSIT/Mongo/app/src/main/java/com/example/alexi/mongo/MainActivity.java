package com.example.alexi.mongo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity{
    private RFService mService;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d("MainActivity", "call RFInterface.getEmbeddedService()");
        mService = RFService.retrofit.create(RFService.class);

        scrollView = findViewById(R.id.login_form);
        scrollView.removeAllViews();
        TextView tv = new TextView(this);
        tv.setText(getResources().getString(R.string.action_sign_in));
        scrollView.addView(tv);


        Button btn = findViewById(R.id.email_sign_in_button);
        btn.setOnClickListener((View view) -> {
            Log.d("MainActivity", "getRFResponse()");
            getRFResponse();
        });
    }

    public void getRFResponse(){
        mService.getPOJO().enqueue(new Callback<POJO>() {

            private ArrayList<Embedded> users = new ArrayList<>();

            @Override
            public void onResponse(Call<POJO> call, Response<POJO> response) {

                Log.d("LoginActivity", "onresponse()");

                if(response.isSuccessful()) {
                    Log.d("LoginActivity", "onresponse.isSuccessful()");
                    Toast.makeText(MainActivity.this, "get response", Toast.LENGTH_SHORT);
                    users = (ArrayList<Embedded>)response.body().getEmbedded();


                } else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                    Log.d("LoginActivity", "handle request errors");
                }
            }

            @Override
            public void onFailure(Call<POJO> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    void showErrorMessage(){
        Log.d("LoginActivity", "Error");
    }
}
