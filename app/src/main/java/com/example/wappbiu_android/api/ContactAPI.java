package com.example.wappbiu_android.api;

import com.example.wappbiu_android.R;
import com.example.wappbiu_android.WAppBIU_Android;
import com.example.wappbiu_android.entities.Contact;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(2, TimeUnit.MINUTES)
//                .readTimeout(2, TimeUnit.MINUTES)
//                .writeTimeout(2, TimeUnit.MINUTES)
//                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(WAppBIU_Android.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                //.client(okHttpClient)
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }
    public void get(List<Contact> contacts) {
        Call<List<Contact>> call = webServiceAPI.getAllContacts("david");
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
    public void post(Contact contact) {
        Call<Contact> call = webServiceAPI.createContact("david",contact);
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
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
            public void onFailure(Call<Contact> call, Throwable t) {
            }
        });
    }

    public void getContact(String id) {
        Call<Contact> call = webServiceAPI.getContact(id, "david");
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
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
            public void onFailure(Call<Contact> call, Throwable t) {
            }
        });
    }

}
