package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Piesa;
import com.ubb.postuniv.domain.PiesaCuRaportPretStoc;
import com.ubb.postuniv.domain.PiesaValidator;
import com.ubb.postuniv.domain.TipPiesaCuMediePreturi;
import com.ubb.postuniv.repository.InMemoryPiesaRepository;

import java.util.*;

public class PiesaService {
    private InMemoryPiesaRepository piesaRepository;
    private PiesaValidator piesaValidator;

    public PiesaService(InMemoryPiesaRepository piesaRepository, PiesaValidator piesaValidator) {
        this.piesaRepository = piesaRepository;
        this.piesaValidator = piesaValidator;
    }

    public void addPiesa(String id, String denumire, float pret,
                         int stoc, String tip) {
        Piesa piesa = new Piesa(id, denumire, pret, stoc, tip);
        this.piesaValidator.validate(piesa);
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

    public List<TipPiesaCuMediePreturi> getTipuriPieseCuMediePreturi() {
        Map<String, List<Float>> groupings = new HashMap<>();
        for (Piesa piesa: this.getAll()) {
            String tip = piesa.getTip();
            float pret = piesa.getPret();
            if (groupings.containsKey(tip)) {
                groupings.get(tip).add(pret);
            } else {
                List<Float> prices = new ArrayList<>();
                prices.add(pret);
                groupings.put(tip, prices);
            }
        }

        List<TipPiesaCuMediePreturi> result = new ArrayList<>();
        for (String tip : groupings.keySet()) {
            float medie = 0;
            for (float pret : groupings.get(tip)) {
                medie += pret;
            }
            medie /= groupings.get(tip).size();

            result.add(new TipPiesaCuMediePreturi(tip, medie));
        }

        return result;
    }

    public List<Piesa> getAll() {
        return piesaRepository.read();
    }
}
