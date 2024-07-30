package com.example.healthassistant.ui.bmicalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class    BMICalculatorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BMICalculatorViewModel() {
        mText = new MutableLiveData<>();
       // mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}