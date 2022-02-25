package com.ubb.postuniv.userInterface;

import com.ubb.postuniv.domain.Piesa;
import com.ubb.postuniv.domain.PiesaCuRaportPretStoc;
import com.ubb.postuniv.service.PiesaService;

import java.util.Scanner;

public class Console {
    private PiesaService piesaService;
    Scanner scanner = new Scanner(System.in);

    public Console(PiesaService piesaService) {
        this.piesaService = piesaService;
    }

    public void runUi() {
        while (true) {
            this.showMenu();
            String opt = this.scanner.nextLine();
            switch (opt) {
                case "1":
                    this.handleAddPiesa();
                    break;
                case "a":
                    this.handleShowAllPiese();
                    break;
                case "r1":
                    this.handleShowPieseSortedByPretOverStoc();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleShowPieseSortedByPretOverStoc() {
        for (PiesaCuRaportPretStoc piesaRaport : this.piesaService.getPieseSortedByPretOverStoc()) {
            System.out.println(piesaRaport);
        }
    }

    private void handleShowAllPiese() {
        for (Piesa piesa : this.piesaService.getAll()) {
            System.out.println(piesa);
        }
    }

    private void handleAddPiesa() {
        try {
            System.out.println("Dati id-ul piesei (unic):");
            String id = this.scanner.nextLine();

            System.out.println("Dati denumirea piesei (nenula):");
            String denumire = this.scanner.nextLine();

            System.out.println("Dati pretul piesei:");
            float pret = this.scanner.nextFloat();

            System.out.println("Dati stocul piesei (> 0):");
            int stoc = this.scanner.nextInt();

            this.scanner.nextLine();
            System.out.println("Dati tipul piesei (dintre OEM, AM, SH):");
            String tip = this.scanner.nextLine();

            this.piesaService.addPiesa(id, denumire, pret, stoc, tip);
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }
    }

    private void showMenu() {
        System.out.println("1. Adauga piesa");
        System.out.println("r1. Raport cu piese ordonate descrescator dupa raportul pret / stoc");
        System.out.println("a. Afisare piese");
        System.out.println("x. Iesire");
    }
}
