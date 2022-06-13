package com.example.wappbiu_android.viewmodels;
import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.wappbiu_android.daos.ContactDao;

public class MessageViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private Object[] mParams;
    public MessageViewModelFactory(Application application, Object[] param) {
        mApplication = application;
        mParams = param;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MessagesViewModel(mApplication,(String) mParams[0], (String) mParams[1]);
    }


}
