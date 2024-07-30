package com.example.healthassistant.ui.sos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SOSViewModel extends ViewModel {

    private MutableLiveData<String> textSos;

    public SOSViewModel() {
        textSos = new MutableLiveData<>();
        textSos.setValue("SOS Feature Content"); // Initial content
    }

    public LiveData<String> getText() {
        return textSos;
    }
}
