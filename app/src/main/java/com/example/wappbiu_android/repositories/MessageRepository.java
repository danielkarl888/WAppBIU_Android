package com.example.wappbiu_android.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wappbiu_android.ChatActivity;
import com.example.wappbiu_android.ContactsActivity;
import com.example.wappbiu_android.api.MessageAPI;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MessageRepository {
    private MessageListData messageListData;
    private MessageAPI api;
    private String contact_name;
    private String logged_user;

    public MessageRepository(String contact_name, String logged_user) {
        this.messageListData = new MessageListData();
        this.api = new MessageAPI();
        this.logged_user = logged_user;
        this.contact_name = contact_name;
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
                api.getAllMessages(this, logged_user, contact_name);
            }).start();
        }

    }
    public LiveData<List<Message>> getAll() {
        return messageListData;
    }
    public void addMessage(Message message) {
        new Thread(()->{
            api.addMessages(messageListData, message,contact_name, logged_user);
        }).start();
    }



}
