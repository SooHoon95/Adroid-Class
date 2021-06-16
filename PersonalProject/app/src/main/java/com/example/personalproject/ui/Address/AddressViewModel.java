package com.example.personalproject.ui.Address;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.personalproject.NetworkTask.NetworkTask;

public class AddressViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String urlAddr = null;
    private String macIP = "192.168.0.3";
    private String urlAddr = "http://" + macIP + ":8080/test/student_query_all.jsp";

    public AddressViewModel() {
        NetworkTask = new NetworkTask(getA,urlAddr,"select");
    }

    public LiveData<String> getText() {
        return mText;
    }
}