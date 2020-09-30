package com.vianelloalessandro.iblogger_app;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class PostDialog extends DialogFragment {

    public static final  String TAG = PostDialog.class.getName();

    private Button mBtnSendPost;
    private Button mBtnCancel;
    private EditText mEtTitle;
    private EditText mEtContent;

    private CompositeSubscription mSubscriptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_post,container,false);
        mSubscriptions = new CompositeSubscription();
        initView(view);
        return view;
    }

    private void initView(View v) {

        mBtnCancel = v.findViewById(R.id.btn_cancel);
        mBtnSendPost = v.findViewById(R.id.btn_send_post);
        mEtContent = (EditText) v.findViewById(R.id.et_content);
        mEtTitle = (EditText)  v.findViewById(R.id.et_title);

        mBtnCancel.setOnClickListener(view -> dismiss());
        mBtnSendPost.setOnClickListener(view -> postProgress());

    }

    private void postProgress() {

        Post post = new Post();
        post.setTitle(mEtTitle.getText().toString());
        post.setContent(mEtContent.getText().toString());

        mSubscriptions.add(NetworkUtilPost.getRetrofit().savePost(post)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));

    }

    private void handleError(Throwable throwable) {

        Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG);

    }

    private void handleResponse(ResponseApp responseApp) {

        Toast.makeText(getActivity(),"Post Saved Successfully",Toast.LENGTH_LONG);
        dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
