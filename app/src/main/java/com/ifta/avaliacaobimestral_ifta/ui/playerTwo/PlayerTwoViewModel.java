package com.ifta.avaliacaobimestral_ifta.ui.playerTwo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlayerTwoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlayerTwoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Player One fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}