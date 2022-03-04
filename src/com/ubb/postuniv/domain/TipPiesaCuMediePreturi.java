package com.ubb.postuniv.domain;

public class TipPiesaCuMediePreturi {

    public String tipPiesa;
    public float mediaPreturi;

    public TipPiesaCuMediePreturi(String tipPiesa, float mediaPreturi) {
        this.tipPiesa = tipPiesa;
        this.mediaPreturi = mediaPreturi;
    }

    @Override
    public String toString() {
        return "TipPiesaCuMediePreturi{" +
                "tipPiesa='" + tipPiesa + '\'' +
                ", mediaPreturi=" + mediaPreturi +
                '}';
    }
}
