package com.example.wappbiu_android.viewmodels;
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

    public MessagesViewModel() {
        this.mRepository = new MessageRepository();
        this.messagesList = mRepository.getAll();

    }

    public LiveData<List<Message>> getMessagesList() {
        return messagesList;
    }
}
