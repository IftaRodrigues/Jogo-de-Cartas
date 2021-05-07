package com.ifta.avaliacaobimestral_ifta.ui.descricao;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ifta.avaliacaobimestral_ifta.MainActivity;
import com.ifta.avaliacaobimestral_ifta.R;
import com.ifta.avaliacaobimestral_ifta.control.AdapterCard;
import com.ifta.avaliacaobimestral_ifta.control.Auxilia;
import com.ifta.avaliacaobimestral_ifta.control.Conexao;
import com.ifta.avaliacaobimestral_ifta.model.Card;
import com.ifta.avaliacaobimestral_ifta.model.Deck;
import com.ifta.avaliacaobimestral_ifta.ui.playerOne.PlayerOneFragment;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DescricaoFragment extends Fragment {

    private DescricaoViewModel descricaoViewModel;
    private TextView textViewId;
    private ListView listViewCards;
    private static final String URL_DECK="https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
    private StringBuilder builderDeck =  new StringBuilder();
    private StringBuilder builderCards=  new StringBuilder();
    private Deck deck, deckCard;
//    private ArrayAdapter adapter;
    private AdapterCard adapterCard;
    public static List<Card> cards= new ArrayList<>();
    private View root;
    private Gson gson;
    private Auxilia auxilia;
    private LayoutInflater inflaterRoot;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        descricaoViewModel =
                new ViewModelProvider(this).get(DescricaoViewModel.class);
        root = inflater.inflate(R.layout.fragment_descricao, container, false);
        textViewId= root.findViewById(R.id.id_text_view);
        listViewCards= root.findViewById(R.id.list_cartas);
        inflaterRoot=inflater;

        new obterDados().execute();


        return root;
    }


    private class obterDados extends AsyncTask<Void, Void, List<Card>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(root.getContext(), "Dowloading: arquivo JSON", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected List<Card> doInBackground(Void... voids) {
            Conexao conexao= new Conexao();
            InputStream inputStream= conexao.obterRespostaHTTP(URL_DECK);
            InputStream inputStreamCards;
            auxilia = new Auxilia();
            gson = new Gson();
            String textoDeckJSON= auxilia.converter(inputStream);



            if (textoDeckJSON != null){
                Type typeDeck = new TypeToken<Deck>() {}.getType();
                deck= gson.fromJson(textoDeckJSON, typeDeck);

                builderDeck.append(deck.getDeckId()).append("\n");

                //carregar as cartas
                inputStreamCards=conexao.obterRespostaHTTP("https://deckofcardsapi.com/api/deck/"+deck.getDeckId()+"/draw/?count=20");
                String textoCardJSON= auxilia.converter(inputStreamCards);


                if (textoCardJSON!= null){
                    deckCard = gson.fromJson(textoCardJSON, typeDeck);
                    cards= deckCard.getCards();


                }
                return cards;

            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Card> cards) {
            super.onPostExecute(cards);
            textViewId.setText(builderDeck.toString());
            adapterCard = new AdapterCard(cards, inflaterRoot);
            listViewCards.setAdapter(adapterCard);

        }
    }

}