package com.vianelloalessandro.iblogger_app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ProfileFragment extends Fragment implements ChangePasswordDialog.Listener{

    public static final String TAG = ProfileFragment.class.getSimpleName();

    private TextView mTvName;
    private TextView mTvEmail;
    private TextView mTvDate;
    private Button mBtChangePassword;
    private Button mBtLogout;
    private Button mBtDelete;
    private Button mBtMainPage;

    private ProgressBar mProgressbar;

    private SharedPreferences mSharedPreferences;
    private String mToken;
    private String mEmail;
    View v;

    private CompositeSubscription mSubscriptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        v = inflater.inflate(R.layout.fragment_profile,container,false);
        mSubscriptions = new CompositeSubscription();
        initViews(v);
        initSharedPreferences();
        loadProfile();
        return v;
    }

    private void initViews(View v) {

        mTvName = (TextView) v.findViewById(R.id.tv_name);
        mTvEmail = (TextView) v.findViewById(R.id.tv_email);
        mTvDate = (TextView) v.findViewById(R.id.tv_date);
        mBtChangePassword = (Button) v.findViewById(R.id.btn_change_password);
        mBtLogout = (Button) v.findViewById(R.id.btn_logout);
        mBtDelete = (Button) v.findViewById(R.id.btn_delete);
        mBtMainPage = (Button) v.findViewById(R.id.btn_mainPageProfile);
        mProgressbar = (ProgressBar) v.findViewById(R.id.progress);

        mBtMainPage.setOnClickListener(view -> goToMainPage());
        mBtChangePassword.setOnClickListener(view -> showDialog());
        mBtLogout.setOnClickListener(view -> logout());
        mBtDelete.setOnClickListener(view -> deleteAccount());

    }

    private void goToMainPage() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MainPageFragment fragment = new MainPageFragment();
        ft.replace(R.id.activity_main,fragment,MainPageFragment.TAG);
        ft.commit();
    }

    private void initSharedPreferences() {

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mToken = mSharedPreferences.getString(Constants.TOKEN,"");
        mEmail = mSharedPreferences.getString(Constants.EMAIL,"");
    }

    private void logout() {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(Constants.EMAIL,"");
        editor.putString(Constants.TOKEN,"");
        editor.apply();
        getActivity().finish();
    }

    private void showDialog(){

        ChangePasswordDialog fragment = new ChangePasswordDialog();

        Bundle bundle = new Bundle();
        bundle.putString(Constants.EMAIL, mEmail);
        bundle.putString(Constants.TOKEN,mToken);
        fragment.setArguments(bundle);

        fragment.show(getFragmentManager(), ChangePasswordDialog.TAG);
    }

    private void deleteAccount(){

        DeleteDialog fragment = new DeleteDialog();

        Bundle bundle = new Bundle();
        bundle.putString(Constants.NAME,mTvName.getText().toString());
        bundle.putString(Constants.EMAIL,mEmail);
        fragment.setArguments(bundle);

        fragment.show(getFragmentManager(), DeleteDialog.TAG);
    }

    private void loadProfile() {

        mSubscriptions.add(NetworkUtil.getRetrofit(mToken).getProfile(mEmail)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(User user) {

        mProgressbar.setVisibility(View.GONE);
        mTvName.setText(user.getName());
        mTvEmail.setText(user.getEmail());
        mTvDate.setText(user.getCreated_at());
    }

    private void handleError(Throwable error) {

        mProgressbar.setVisibility(View.GONE);

        if (error instanceof HttpException) {

            Gson gson = new GsonBuilder().create();

            try {

                String errorBody = ((HttpException) error).response().errorBody().string();
                ResponseApp responseApp = gson.fromJson(errorBody,ResponseApp.class);
                showSnackBarMessage(responseApp.getMessage(),v);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            showSnackBarMessage("Network Error !",v);
        }
    }

    private void showSnackBarMessage(String message,View v) {

        Snackbar.make(v.findViewById(R.id.activity_profile),message,Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSubscriptions.unsubscribe();
    }

    public void onPasswordChanged() {

        showSnackBarMessage("Password Changed Successfully !",v);
    }
}
