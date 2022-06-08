package com.example.wappbiu_android.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.wappbiu_android.AppDB;
import com.example.wappbiu_android.WAppBIU_Android;
import com.example.wappbiu_android.api.ContactAPI;
import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.entities.Contact;

import java.util.LinkedList;
import java.util.List;

public class ContactsRepository {
//    private ContactDao contactDao;
    private ContactListData contactListData;
    private ContactAPI api;

    public ContactsRepository() {
//        AppDB db  = Room.databaseBuilder(WAppBIU_Android.context, AppDB.class, "WAppBiuDB.db")
//                    .allowMainThreadQueries().build();
//
//        contactDao = db.contactDao();
        contactListData = new ContactListData();
        api = new ContactAPI();
    }
    class ContactListData extends MutableLiveData<List<Contact>> {

        public ContactListData () {
            super();
            List<Contact> posts = new LinkedList<>();
            //setValue(posts);
        }

        @Override
        protected void onActive() {
            super.onActive();
            new Thread(()->{
                api.get(this);
            }).start();
//            PostAPI postAPI = new PostAPI();
//            postAPI.get(this);


        }
    }
    public LiveData<List<Contact>> getAll() {
        return contactListData;
    }
//    public void add(final Post post) {
//        api.add(post);
//    }
//
//    public void delete(final Post post) {
//        api.delete(post);
//    }
//    public void reload() {
//        api.get(postListData);
//    }


}
