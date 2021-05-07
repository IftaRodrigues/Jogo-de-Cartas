package com.ifta.avaliacaobimestral_ifta.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Deck implements Serializable
{

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("deck_id")
    @Expose
    private String deckId;
    @SerializedName("remaining")
    @Expose
    private Integer remaining;
    @SerializedName("shuffled")
    @Expose
    private String shuffled;
    private final static long serialVersionUID = -8174679528891804748L;

    @SerializedName("cards")
    @Expose
    private List<Card> cards = null;
    @SerializedName("remaining")


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public String getShuffled() {
        return shuffled;
    }

    public void setShuffled(String shuffled) {
        this.shuffled = shuffled;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }



}