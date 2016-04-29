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
 * Class for printing info from FishReferee.
 */
public class Printer {

    /**
     * Lists available species according to their swimming floor.
     *
     * @param top list of species swimming at top floor
     * @param mid list of species swimming at mid floor
     * @param bottom list of species swimming at bottom floor
     * @return String of species
     */
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

    /**
     * Lists recommended fish and their amount.
     *
     * @param list list of recommended fish from FishReferee
     * @return String of recommended fish
     */
    public String getFinalFish(ArrayList<Fish> list) {
        String fish = "";
        try {
            for (Fish x : list) {
                fish = fish + System.lineSeparator() + x.getSpecies().getName() + ", " + x.getAmount() + " kpl";
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return fish;
    }

    /**
     * Method for printing information from species.
     *
     * @param list list of available species from FishReferee
     * @param text name of species to search information
     * @return String formed information
     */
    public String getInfo(ArrayList<Species> list, String text) {
        String social = "erakko";

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
                    if (spe.isSocial) {
                        social = "parvikala";
                    }
                    String info = "Nimi: " + spe.getName() + "\n" + "Latinankielinen nimi: " + spe.getLatinName() + "\n" + "Sosiaalisuus: " + social + "\n" + "Akvaarion minimikoko litroissa: " + spe.getaqMinSize() + "\n" + "Uintikerros: " + floor + "\n" + "Pituus cm: " + spe.getLenght() + "\n" + "MinimipH: " + spe.getMinpH() + "\n" + "MaksimipH: " + spe.getMaxpH() + "\n" + "Minimilämpötila: " + spe.getTempMin() + "\n" + "Maksimilämpötila: " + spe.getTempMax();
                    return info;
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Lista on tyhjä.");
        }

        return "";
    }
}
