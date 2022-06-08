package com.example.wappbiu_android.api;

import android.icu.text.UnicodeSetIterator;

import androidx.lifecycle.MutableLiveData;
import androidx.room.DatabaseConfiguration;

import com.example.wappbiu_android.R;
import com.example.wappbiu_android.WAppBIU_Android;
import com.example.wappbiu_android.entities.Contact;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactAPI {
    Retrofit retrofit;
    WebServiceAPI webServiceAPI;
    public ContactAPI() {
        //this.postListData = postListData;
        //this.dao = dao;

        retrofit = new Retrofit.Builder()
                .baseUrl(WAppBIU_Android.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }
    public void get(List<Contact> contacts) {
        Call<List<Contact>> call = webServiceAPI.getContact("david");
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                // save it into the db. in addition , update the screen - with calling the repo

                response.body();
             /*
                new Thread(() -> {
                    dao.clear();
                    dao.insertList(response.body());
                    postListData.postValue(dao.get());
                }).start();
                */

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
            }
        });
    }

}
