package com.example.wappbiu_android.api;

import androidx.lifecycle.MutableLiveData;

import com.example.wappbiu_android.R;
import com.example.wappbiu_android.WAppBIU_Android;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageAPI {
    Retrofit retrofit;
    WebServiceAPI webServiceAPI;
    private String logged_user;
    private String id_contact;
    public MessageAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(WAppBIU_Android.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                //.client(okHttpClient)
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }

    public void get(MutableLiveData<List<Message>> messages) {
        Call<List<Message>> call = webServiceAPI.getMessages("raz","david");
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
//                // save it into the db. in addition , update the screen - with calling the repo
//                response.body().get(0).setLastDate(new Date());
//                response.body().get(1).setLastDate(new Date());
//                response.body().get(2).setLastDate(new Date());
                messages.postValue(response.body());
             /*
                new Thread(() -> {
                    dao.clear();
                    dao.insertList(response.body());
                    postListData.postValue(dao.get());
                }).start();
                */

            }
            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
            }
        });
    }
}
