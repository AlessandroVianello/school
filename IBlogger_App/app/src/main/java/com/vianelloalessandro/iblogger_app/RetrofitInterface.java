package com.vianelloalessandro.iblogger_app;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface RetrofitInterface {

    @POST("users")
    Observable<ResponseApp> register(@Body User user);

    @POST("posts")
    Observable<ResponseApp> savePost(@Body Post post);

    @GET("posts")
    Call<ResponseApp> getPost();

    @POST("authenticate")
    Observable<ResponseApp> login();

    @GET("users/{email}")
    Observable<User> getProfile(@Path("email") String email);

    @PUT("users/{email}")
    Observable<ResponseApp> changePassword(@Path("email") String email, @Body User user);

    @POST("users/{email}/password")
    Observable<ResponseApp> resetPasswordInit(@Path("email") String email);

    @POST("users/{email}/password")
    Observable<ResponseApp> resetPasswordFinish(@Path("email") String email, @Body User user);

    @DELETE("users/{email}/delete")
    Observable<ResponseApp> deleteAccount(@Path("email")String email);
}
