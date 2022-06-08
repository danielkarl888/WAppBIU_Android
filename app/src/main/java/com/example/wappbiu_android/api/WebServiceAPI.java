package com.example.wappbiu_android.api;

import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServiceAPI {
    @GET("Contacts")
    Call<List<Contact>> getAllContacts(@Query("user") String user);

    @POST("Contacts")
   Call<Contact> createContact(@Query("user") String user, @Body Contact contact);
    @GET("Contacts/{id}")
    Call<Contact> getContact(@Path("id") String id, @Query("user") String user);

    @POST("Users/Login")
    Call<User> login(@Body User user);

    @POST("Users/Register")
    Call<User> register(@Body User user);




//    @DELETE("posts/{id}")
//    Call<Void> deletePost(@Path("id") int id);

}
