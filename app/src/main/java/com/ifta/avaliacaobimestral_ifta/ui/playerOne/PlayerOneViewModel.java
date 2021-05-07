package com.ifta.avaliacaobimestral_ifta.ui.playerOne;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlayerOneViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlayerOneViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Player One fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}