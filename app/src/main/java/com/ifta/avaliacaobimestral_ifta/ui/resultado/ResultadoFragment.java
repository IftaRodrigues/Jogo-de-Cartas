package com.ifta.avaliacaobimestral_ifta.ui.resultado;

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
import com.ifta.avaliacaobimestral_ifta.model.Card;
import com.ifta.avaliacaobimestral_ifta.ui.gerarPesos.GerarPesosFragment;
import com.ifta.avaliacaobimestral_ifta.ui.playerOne.PlayerOneFragment;
import com.ifta.avaliacaobimestral_ifta.ui.playerTwo.PlayerTwoFragment;

public class ResultadoFragment extends Fragment {

    private ResultadoViewModel resultadoViewModel;
    private int pontuacaoPlayerOne, pontuacaoPlayerTwo;
    private TextView text_pontucaoplayerone, text_pontucaoplayertwo, text_resultado;
    

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resultadoViewModel =
                new ViewModelProvider(this).get(ResultadoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_resultado, container, false);
        text_pontucaoplayerone = root.findViewById(R.id.text_pontucaoplayerone);
        text_pontucaoplayertwo = root.findViewById(R.id.text_pontucaoplayertwo);
        text_resultado = root.findViewById(R.id.text_resultado);

        text_pontucaoplayerone.setText(Integer.toString(geraPontuacaoPlayerOne()));
        text_pontucaoplayertwo.setText(Integer.toString(geraPontuacaoPlayerTwo()));

        resultado();


        return root;
    }
    
    public int geraPontuacaoPlayerOne(){
        for (int i = 0; i < PlayerOneFragment.cardsPlayerOne.size(); i++) {
            Card carta = PlayerOneFragment.cardsPlayerOne.get(i);
            String valorString= carta.getValue();
            int valor;

            //pegando o valor String e transformando para inteiro
            // as cartas As, Valete, Dama e Rei tem respectivamente os valores de 1, 11, 12 e 13
            switch (valorString){
                case "ACE":
                    valor=1;
                    break;
                case "JACK":
                    valor=11;
                    break;
                case "QUEEN":
                    valor=12;
                    break;
                case "KING":
                    valor=13;
                    break;
                default:
                    valor= Integer.parseInt(valorString);
            }

            //valor da carta com o peso do naipe
            String naipe= carta.getSuit();
            switch (naipe){
                case "CLUBS":
                    valor= valor* GerarPesosFragment.pausPeso;
                    break;
                case "DIAMONDS":
                    valor=valor* GerarPesosFragment.ourosPeso;
                    break;
                case "HEARTS":
                    valor=valor* GerarPesosFragment.copasPeso;
                    break;
                case "SPADES":
                    valor=valor* GerarPesosFragment.espadasPeso;
                    break;
            }
            pontuacaoPlayerOne = pontuacaoPlayerOne+valor;
        }
        return pontuacaoPlayerOne;
    }

    public int geraPontuacaoPlayerTwo(){
        for (int i = 0; i < PlayerTwoFragment.cardsPlayerTwo.size(); i++) {
            Card carta = PlayerTwoFragment.cardsPlayerTwo.get(i);
            String valorString= carta.getValue();
            int valor;

            //pegando o valor String e transformando para inteiro
            // as cartas As, Valete, Dama e Rei tem respectivamente os valores de 1, 11, 12 e 13
            switch (valorString){
                case "ACE":
                    valor=1;
                    break;
                case "JACK":
                    valor=11;
                    break;
                case "QUEEN":
                    valor=12;
                    break;
                case "KING":
                    valor=13;
                    break;
                default:
                    valor= Integer.parseInt(valorString);
            }

            //valor da carta com o peso do naipe
            String naipe= carta.getSuit();
            switch (naipe){
                case "CLUBS":
                    valor= valor* GerarPesosFragment.pausPeso;
                    break;
                case "DIAMONDS":
                    valor=valor* GerarPesosFragment.ourosPeso;
                    break;
                case "HEARTS":
                    valor=valor* GerarPesosFragment.copasPeso;
                    break;
                case "SPADES":
                    valor=valor* GerarPesosFragment.espadasPeso;
                    break;
            }
            pontuacaoPlayerTwo = pontuacaoPlayerTwo+valor;
        }
        return pontuacaoPlayerTwo;
    }

    public void resultado(){
        if (pontuacaoPlayerOne > pontuacaoPlayerTwo){
            text_resultado.setText("Player One Venceu!");
        }else if (pontuacaoPlayerOne == pontuacaoPlayerTwo){
            text_resultado.setText("Empatou");
        }else {
            text_resultado.setText("Player Two Venceu!");
        }
    }
}