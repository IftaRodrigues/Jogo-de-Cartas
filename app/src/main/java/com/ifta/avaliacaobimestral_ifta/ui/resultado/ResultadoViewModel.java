package com.ifta.avaliacaobimestral_ifta.ui.resultado;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultadoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ResultadoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Resultado fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}