package com.ifta.avaliacaobimestral_ifta.ui.gerarPesos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ifta.avaliacaobimestral_ifta.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GerarPesosFragment extends Fragment {

    private GerarPesosViewModel gerarPesosViewModel;
    public static int pausPeso,ourosPeso,copasPeso,espadasPeso;
    private Integer[] sequencia = {1,2,3,4,5,6,7,8,9,10};
    private List<Integer> listPesos =Arrays.asList(sequencia);
    private TextView pausText, ourosText, copasText, espadasText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gerarPesosViewModel =
                new ViewModelProvider(this).get(GerarPesosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gerarpesos, container, false);
        pausText= root.findViewById(R.id.text_paus);
        ourosText= root.findViewById(R.id.text_ouros);
        copasText= root.findViewById(R.id.text_copas);
        espadasText= root.findViewById(R.id.text_espadas);

        gerarPesos();
        return root;
    }

    private void gerarPesos(){
        Collections.shuffle(listPesos);
        pausPeso = listPesos.get(0);
        ourosPeso = listPesos.get(1);
        copasPeso = listPesos.get(2);
        espadasPeso = listPesos.get(3);

        pausText.setText(Integer.toString(pausPeso));
        ourosText.setText(Integer.toString(ourosPeso));
        copasText.setText(Integer.toString(copasPeso));
        espadasText.setText(Integer.toString(espadasPeso));
    }
}