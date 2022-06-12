package com.example.wappbiu_android.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wappbiu_android.api.MessageAPI;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MessageRepository {
    private MessageListData messageListData;
    private MessageAPI api;

    public MessageRepository() {
        this.messageListData = new MessageListData();
        this.api = new MessageAPI();
    }

    class MessageListData extends MutableLiveData<List<Message>>{
        public MessageListData () {
            super();
            List <Message> messages = new LinkedList<>();
        }

        @Override
        protected void onActive() {
            super.onActive();
            new Thread(()->{
                api.get(this);
            }).start();
        }
    }
    public LiveData<List<Message>> getAll() {
        return messageListData;
    }

}
