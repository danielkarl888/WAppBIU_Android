package com.example.wappbiu_android.viewmodels;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.wappbiu_android.daos.ContactDao;

public class MyViewModelFactory implements ViewModelProvider.Factory{
    private Application mApplication;
    private Object[] mParams;
    public MyViewModelFactory(Application application, Object[] param) {
        mApplication = application;
        mParams = param;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new ContactsViewModel(mApplication,(String) mParams[0], (ContactDao) mParams[1]);
    }


}
