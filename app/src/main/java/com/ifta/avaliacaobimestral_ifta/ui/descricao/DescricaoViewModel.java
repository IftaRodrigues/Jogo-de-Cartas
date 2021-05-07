package com.ifta.avaliacaobimestral_ifta.ui.descricao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DescricaoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DescricaoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Descrição fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}