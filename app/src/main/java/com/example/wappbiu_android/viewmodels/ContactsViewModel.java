package com.example.wappbiu_android.viewmodels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.repositories.ContactsRepository;

import java.util.List;

public class ContactsViewModel extends ViewModel{

    private LiveData<List<Contact>> contacts;
    private ContactsRepository mRepository;

    public ContactsViewModel() {
        this.mRepository = new ContactsRepository();
        this.contacts = mRepository.getAll();
    }

    public LiveData<List<Contact>> get(){ return contacts;}

//    public void add(Post post){ mRepository.add(post);}
//
//    public void delete(Post post){ mRepository.delete(post);}

//    public void reload(){ mRepository.reload();}


}
