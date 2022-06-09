package com.example.wappbiu_android.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    // MutableLiveData is an observer
    private MutableLiveData<String> error;
    // it can be impossible to regi to updateds on this variable. if it is changed, all observers are notified
    public MutableLiveData<String> getError(){
        if (error == null) {
            error = new MutableLiveData<>();
            //return error;
        }
        return error;
    }
    public String getData() {
        return error.getValue();
    }
}
