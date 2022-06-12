package com.example.wappbiu_android.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class notificationService extends FirebaseMessagingService {
    public notificationService() {
    }

}