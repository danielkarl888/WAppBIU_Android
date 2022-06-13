package com.example.wappbiu_android.viewmodels;
import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.wappbiu_android.entities.Message;
import com.example.wappbiu_android.repositories.ContactsRepository;
import com.example.wappbiu_android.repositories.MessageRepository;

import java.util.ArrayList;
import java.util.List;


public class MessagesViewModel extends ViewModel {

    private LiveData<List<Message>> messagesList;
    private MessageRepository mRepository;
    private String contact_name;
    private String logged_user;
    private Application application;



    public MessagesViewModel(Application mApplication,String logged_user, String contact_name) {
        this.mRepository = new MessageRepository(contact_name,logged_user);
        this.messagesList = mRepository.getAll();
        this.contact_name = contact_name;
        this.logged_user = logged_user;
        this.application = mApplication;

    }

    public LiveData<List<Message>> getMessagesList() {
        return messagesList;
    }
}
