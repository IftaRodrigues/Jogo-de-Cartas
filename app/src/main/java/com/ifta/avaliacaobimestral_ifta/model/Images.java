package com.ifta.avaliacaobimestral_ifta.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images implements Serializable{

        @SerializedName("svg")
        @Expose
        private String svg;
        @SerializedName("png")
        @Expose
        private String png;
        private final static long serialVersionUID = -7535599886184546904L;

        public String getSvg() {
            return svg;
        }

        public void setSvg(String svg) {
            this.svg = svg;
        }

        public String getPng() {
            return png;
        }

        public void setPng(String png) {
            this.png = png;
        }

}