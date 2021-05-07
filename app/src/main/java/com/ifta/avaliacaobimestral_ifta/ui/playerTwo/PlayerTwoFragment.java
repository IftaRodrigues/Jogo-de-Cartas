package com.ifta.avaliacaobimestral_ifta.ui.playerTwo;

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

public class PlayerTwoFragment extends Fragment {
    private Random r = new Random();
    public static List<Card> cardsDisponiveis= DescricaoFragment.cards;
    public static List<Card> cardsPlayerTwo =  new ArrayList<>();
    private ListView listViewCards;
    private AdapterCard adapterCard;
    private LayoutInflater inflaterRoot;

    private PlayerTwoViewModel playerOneViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        playerOneViewModel =
                new ViewModelProvider(this).get(PlayerTwoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_playertwo, container, false);
        listViewCards= root.findViewById(R.id.list_playerTwo);


        inflaterRoot=inflater;
        adapterCard = new AdapterCard(selecionarCartas(), inflaterRoot);
        listViewCards.setAdapter(adapterCard);

        return root;
    }

    public List<Card> selecionarCartas(){
        cardsPlayerTwo.clear();

        Collections.shuffle(cardsDisponiveis);
        
        for (int i = 0; i < 3; i++) {
            cardsPlayerTwo.add(cardsDisponiveis.get(i));

        }
        removerCartas(cardsPlayerTwo);
        System.out.println(cardsDisponiveis.size());
        return cardsPlayerTwo;
    }

    public void removerCartas(List<Card> cardsPlayerTwo){
        for (int i = 0; i < cardsPlayerTwo.size(); i++) {
            cardsDisponiveis.remove(i);
        }
    }
}