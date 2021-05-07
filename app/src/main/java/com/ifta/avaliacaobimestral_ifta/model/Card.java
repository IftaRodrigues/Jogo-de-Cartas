package com.ifta.avaliacaobimestral_ifta.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card implements Serializable {
    @SerializedName("code")
@Expose
private String code;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("suit")
    @Expose
    private String suit;
    private final static long serialVersionUID = -5263459682060332190L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "Código='" + code + '\'' +
                ", Valor='" + value + '\'' +
                ", Naipe='" + suit + '\'' +
                '}';
    }
}