package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Piesa;
import com.ubb.postuniv.domain.PiesaCuRaportPretStoc;
import com.ubb.postuniv.repository.InMemoryPiesaRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PiesaService {
    private InMemoryPiesaRepository piesaRepository;

    public PiesaService(InMemoryPiesaRepository piesaRepository) {
        this.piesaRepository = piesaRepository;
    }

    public void addPiesa(String id, String denumire, float pret,
                         int stoc, String tip) {
        Piesa piesa = new Piesa(id, denumire, pret, stoc, tip);
        this.piesaRepository.create(piesa);
    }

    public List<PiesaCuRaportPretStoc> getPieseSortedByPretOverStoc() {
        List<PiesaCuRaportPretStoc> result = new ArrayList<>();
        for (Piesa piesa: this.getAll()) {
            result.add(new PiesaCuRaportPretStoc(piesa, piesa.getPret() / piesa.getStoc()));
        }

        result.sort(new Comparator<PiesaCuRaportPretStoc>() {
            @Override
            public int compare(PiesaCuRaportPretStoc o1, PiesaCuRaportPretStoc o2) {
                return Float.compare(o2.valoareRaportPretStoc, o1.valoareRaportPretStoc);
            }
        });

        return result;
    }

    public List<Piesa> getAll() {
        return piesaRepository.read();
    }
}
