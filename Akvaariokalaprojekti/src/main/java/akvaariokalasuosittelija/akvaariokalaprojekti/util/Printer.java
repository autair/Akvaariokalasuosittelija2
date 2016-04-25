/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.util;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Fish;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import java.util.ArrayList;

/**
 *
 * @author autair
 */
public class Printer {

    public Printer() {

    }

    public String getAvailableSpecies(ArrayList<Species> top, ArrayList<Species> mid, ArrayList<Species> bottom) {
        String species = "";
        species = "Pintaveden kalat: ";
        for (Species x : top) {
            species = species + System.lineSeparator() + x.getName();
        }
        species = species + "\n" + "Keskiveden kalat: ";
        for (Species z : mid) {
            species = species + System.lineSeparator() + z.getName();
        }
        species = species + "\n" + "Pohjaveden kalat: ";
        for (Species y : bottom) {
            species = species + System.lineSeparator() + y.getName();
        }

        return species;
    }

    public String getFinalFish(ArrayList<Fish> list) {
        String fish = "";
        for (Fish x : list) {
            fish = fish + System.lineSeparator() + x.getSpecies().getName() + ", " + x.getAmount() + " kpl";
        }
        return fish;
    }

    public String getInfo(ArrayList<Species> list, String text) {

        try {
            for (Species spe : list) {
                if (spe.getName().equals(text)) {
                    String floor = "";
                    if (spe.getFloor().equals("top")) {
                        floor = "pinta";
                    }
                    if (spe.getFloor().equals("mid")) {
                        floor = "keski";
                    }
                    if (spe.getFloor().equals("bottom")) {
                        floor = "pohja";
                    }
                    String info = "Nimi: " + spe.getName() + "\n" + "Latinankielinen nimi: " + spe.getLatinName() + "\n" + "Akvaarion minimikoko litroissa: " + spe.getaqMinSize() + "\n" + "Uintikerros: " + floor + "\n" + "Pituus cm: " + spe.getLenght() + "\n" + "MinimipH: " + spe.getMinpH() + "\n" + "MaksimipH: " + spe.getMaxpH() + "\n" + "Minimilämpötila: " + spe.getTempMin() + "\n" + "Maksimilämpötila: " + spe.getTempMax();
                    return info;
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Lista on tyhjä.");
        }

        return "";
    }
}
