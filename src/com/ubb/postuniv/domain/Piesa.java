package com.ubb.postuniv.domain;

public class Piesa {
    private String id;
    private String denumire;
    private float pret;
    private int stoc;
    private String tip;

    public Piesa(String id, String denumire, float pret, int stoc, String tip) {
        this.id = id;
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
        this.tip = tip;
    }

    public String getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public float getPret() {
        return pret;
    }

    public int getStoc() {
        return stoc;
    }

    public String getTip() {
        return tip;
    }

    @Override
    public String toString() {
        return "Piesa{" +
                "id='" + id + '\'' +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", stoc=" + stoc +
                ", tip='" + tip + '\'' +
                '}';
    }
}
