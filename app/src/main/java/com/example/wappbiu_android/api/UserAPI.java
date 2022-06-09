package com.example.wappbiu_android.api;

import com.example.wappbiu_android.R;
import com.example.wappbiu_android.WAppBIU_Android;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.User;
import com.example.wappbiu_android.viewmodels.LoginViewModel;
import com.example.wappbiu_android.viewmodels.RegisterViewModel;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAPI {
    Retrofit retrofit;
    WebServiceAPI webServiceAPI;
    public UserAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(WAppBIU_Android.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                //.client(okHttpClient)
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }

    public void regi(User user, RegisterViewModel registerViewModel) {
        Call<User> call = webServiceAPI.register(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // save it into the db. in addition , update the screen - with calling the repo
                new Thread(() -> {
                    response.body();
                    if (response.isSuccessful()) {
                        registerViewModel.getError().postValue("");
                    } else {
                        registerViewModel.getError().postValue("username/password is not valid!");
                    }}).start();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }


    public void login(User user, LoginViewModel loginViewModel) {
        Call<User> call = webServiceAPI.login(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // save it into the db. in addition , update the screen - with calling the repo
                new Thread(() -> {
                    response.body();
                    if (response.isSuccessful()) {
                        loginViewModel.getError().postValue("");
                    } else {
                        loginViewModel.getError().postValue("username/password is not valid!");
                    }}).start();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }
    }

