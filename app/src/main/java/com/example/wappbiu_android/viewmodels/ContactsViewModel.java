package com.example.wappbiu_android.viewmodels;
import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.repositories.ContactsRepository;

import java.util.List;

public class ContactsViewModel extends ViewModel{

    private LiveData<List<Contact>> contacts;
    private ContactsRepository mRepository;
    private ContactDao contactDao;
    private Application application;
    private String param;

    public ContactsViewModel(Application mApplication, String mParam, ContactDao contactDao) {
        this.mRepository = new ContactsRepository(mParam, contactDao);
        this.param = mParam;
        this.contacts = mRepository.getAll();
        this.application =mApplication;
        this.contactDao = contactDao;
    }


    public LiveData<List<Contact>> get(){ return contacts;}

//    public void add(Post post){ mRepository.add(post);}
//
//    public void delete(Post post){ mRepository.delete(post);}

//    public void reload(){ mRepository.reload();}


}
