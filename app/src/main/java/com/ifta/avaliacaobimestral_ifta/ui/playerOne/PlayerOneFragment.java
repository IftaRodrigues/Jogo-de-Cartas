package com.ifta.avaliacaobimestral_ifta.ui.playerOne;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ifta.avaliacaobimestral_ifta.R;
import com.ifta.avaliacaobimestral_ifta.control.AdapterCard;
import com.ifta.avaliacaobimestral_ifta.model.Card;
import com.ifta.avaliacaobimestral_ifta.ui.descricao.DescricaoFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayerOneFragment extends Fragment {
    private Random r = new Random();
    public static List<Card> cardsDisponiveis= DescricaoFragment.cards;
    public static List<Card> cardsPlayerOne =  new ArrayList<>();
    private ListView listViewCards;
    private AdapterCard adapterCard;
    private LayoutInflater inflaterRoot;

    private PlayerOneViewModel playerOneViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        playerOneViewModel =
                new ViewModelProvider(this).get(PlayerOneViewModel.class);
        View root = inflater.inflate(R.layout.fragment_playerone, container, false);
        listViewCards= root.findViewById(R.id.list_playerOne);


        inflaterRoot=inflater;
        adapterCard = new AdapterCard(selecionarCartas(), inflaterRoot);
        listViewCards.setAdapter(adapterCard);

        return root;
    }

    public List<Card> selecionarCartas(){
        cardsPlayerOne.clear();
        Collections.shuffle(cardsDisponiveis);
        
        for (int i = 0; i < 3; i++) {
            cardsPlayerOne.add(cardsDisponiveis.get(i));
        }
        removerCartas(cardsPlayerOne);
        return cardsPlayerOne;
    }

    public void removerCartas(List<Card> cardsPlayerOne){
        for (int i = 0; i < cardsPlayerOne.size(); i++) {
            cardsDisponiveis.remove(i);
        }
    }
}