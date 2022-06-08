package com.example.wappbiu_android.api;

import com.example.wappbiu_android.entities.Contact;

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
    Call<List<Contact>> getContact(@Query("user") String user);

//    @POST("posts")
//    Call<Void> createPost(@Body Post post);

//    @DELETE("posts/{id}")
//    Call<Void> deletePost(@Path("id") int id);

}
