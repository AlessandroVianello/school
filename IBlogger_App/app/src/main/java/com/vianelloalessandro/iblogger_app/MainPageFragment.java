package com.vianelloalessandro.iblogger_app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.subscriptions.CompositeSubscription;

public class MainPageFragment extends Fragment {




        public static final String TAG = MainPageFragment.class.getSimpleName();

    private Button mBtProfile;
    private Button mBtPost;
    private RecyclerView mLvPosts;
    private ArrayList<Post> posts;
    private DataAdapter adapter;

    private CompositeSubscription mSubscriptions;;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page,container,false);
        mSubscriptions = new CompositeSubscription();
        initViews(view);
        return view;
    }


    private void initViews(View v){
        mBtProfile = (Button) v.findViewById(R.id.profile_button);
        mBtPost = (Button) v.findViewById(R.id.post_button);
        mLvPosts = (RecyclerView) v.findViewById(R.id.posts_view);
        mLvPosts.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mLvPosts.setLayoutManager(layoutManager);
        getPostsProgress();
        //Toast.makeText(getActivity(),posts.get(0).getTitle(),Toast.LENGTH_LONG).show();


        mBtProfile.setOnClickListener(view -> goToProfile());
        mBtPost.setOnClickListener(view -> postDialog());
    }


    private void goToProfile() {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ProfileFragment fragment = new ProfileFragment();
            ft.replace(R.id.activity_main,fragment,ProfileFragment.TAG);
            ft.commit();
    }

    private void postDialog() {
        PostDialog dialog = new PostDialog();
        dialog.show(getFragmentManager(),PostDialog.TAG);
    }

    private void getPostsProgress(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterface request = retrofit.create(RetrofitInterface.class);
        Call<ResponseApp> call = request.getPost();
        call.enqueue(new Callback<ResponseApp>() {
            @Override
            public void onResponse(Call<ResponseApp> call, Response<ResponseApp> responseApp) {

                ResponseApp jsonResponseApp = responseApp.body();
                posts = new ArrayList<>(Arrays.asList(jsonResponseApp.getPost()));
                adapter = new DataAdapter(posts);
                mLvPosts.setAdapter(adapter);

            }
            public void onFailure(Call<ResponseApp> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
