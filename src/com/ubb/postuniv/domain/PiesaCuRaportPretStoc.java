package com.ubb.postuniv.domain;

import com.ubb.postuniv.service.PiesaService;

public class PiesaCuRaportPretStoc {
    public Piesa piesa;
    public float valoareRaportPretStoc;

    public PiesaCuRaportPretStoc(Piesa piesa, float valoareRaportPretStoc) {
        this.piesa = piesa;
        this.valoareRaportPretStoc = valoareRaportPretStoc;
    }

    @Override
    public String toString() {
        return "PiesaCuRaportPretStoc{" +
                "piesa=" + piesa +
                ", valoareRaportPretStoc=" + valoareRaportPretStoc +
                '}';
    }
}
