package com.ifta.avaliacaobimestral_ifta.control;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifta.avaliacaobimestral_ifta.R;
import com.ifta.avaliacaobimestral_ifta.model.Card;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class AdapterCard extends BaseAdapter {

    private List<Card> cards;
    private LayoutInflater inflater;


    public AdapterCard(List<Card> cards,LayoutInflater inflater) {
        this.cards = cards;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.lista_card_personalizada, parent, false);
        Card card= cards.get(position);

        TextView codigo= (TextView) view.findViewById(R.id.lista_card_code);
        TextView valor= (TextView) view.findViewById(R.id.lista_card_valor);
        TextView naipe= (TextView) view.findViewById(R.id.lista_card_naipe);

        ImageView imagemCard = (ImageView) view.findViewById(R.id.lista_card_imagem);

        codigo.setText(card.getCode());
        valor.setText(card.getValue());
        naipe.setText(card.getSuit());


        Picasso.get().load(card.getImage()).into(imagemCard);

        return view;
    }

//    private Bitmap getImageCard(String url){
//        Bitmap imageBitmap = null;
//        try {
//            URL aURL = new URL(url);
//            URLConnection conn = aURL.openConnection();
//            conn.connect();
//            InputStream is = conn.getInputStream();
//            BufferedInputStream bis = new BufferedInputStream(is);
//            imageBitmap = BitmapFactory.decodeStream(bis);
//            bis.close();
//            is.close();
//        } catch (IOException e) {
//            System.out.println("Erro ao baixar imagem"+e);
//        }
//        return imageBitmap;
//    }
}
