package com.ubb.postuniv;

import com.ubb.postuniv.domain.Piesa;
import com.ubb.postuniv.domain.PiesaValidator;
import com.ubb.postuniv.repository.InMemoryPiesaRepository;
import com.ubb.postuniv.service.PiesaService;
import com.ubb.postuniv.userInterface.Console;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        List<Piesa> lstPiese = new ArrayList<>();
//        Piesa p = new Piesa();
//        p.setDenumire("Piesa mea preferata");
//        lstPiese.add(p);
//        p.setDenumire("Alta piesa");
//        System.out.println(p.getDenumire()); // Alta piesa
//        System.out.println(lstPiese.get(0).getDenumire()); // Alta piesa

        InMemoryPiesaRepository piesaRepository = new InMemoryPiesaRepository();
        PiesaValidator piesaValidator = new PiesaValidator();
        PiesaService piesaService = new PiesaService(piesaRepository, piesaValidator);

        piesaService.addPiesa("1", "rulment", 100, 13, "SH");
        piesaService.addPiesa("2", "stergator", 50, 135, "OEM");
        piesaService.addPiesa("3", "baterie", 300, 74, "AM");

        Console console = new Console(piesaService);

        console.runUi();
    }
}
