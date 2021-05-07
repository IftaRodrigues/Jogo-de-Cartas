package com.ifta.avaliacaobimestral_ifta.ui.gerarPesos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GerarPesosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GerarPesosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}