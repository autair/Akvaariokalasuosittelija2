/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.logic;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import akvaariokalasuosittelija.akvaariokalaprojekti.util.DataParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author autair
 */
/**
 * Reads information of Species from a text file and generates first species
 * list.
 */
public class Library {

    private ArrayList<Species> list;
    private int aqSize;
    private File dataFile;

    public Library(String location) {
        this.list = new ArrayList();
        this.aqSize = 0;
        dataFile = new File(location);
        // fishlist.txt
    }

    public ArrayList<Species> getCurrentList() {
        return this.list;
    }

    /**
     * Generates an ArrayList for FishReferee; contains only species which can
     * fit into the users aquarium.
     */
    public ArrayList generateFirstFishlist(int aqVolume) {
        if (aqVolume <= 24) {
            System.err.println("Akvaarion tilavuus ei voi olla negatiivinen eikä alle 25 litraa");
            return null;
        }
        List<String> parsedData = new DataParser().getParsedData(dataFile);

        for (String data : parsedData) {
            String[] parts = data.split(";");
            Species s = createSpecie(parts);

            if (s.getaqMinSize() <= aqVolume) {
                this.list.add(s);
            }
        }

        if (this.list.isEmpty()) {
            System.out.println("Näin pieneen akvaarioon ei voi laittaa kaloja.");
            return null;
        }

        return this.list;
    }

    private Species createSpecie(String[] parts) throws NumberFormatException {
        Species s = new Species();
        s.setAqMinSize(Integer.parseInt(parts[5]));
        s.setFloor(parts[4]);
        s.setIsSocial(Boolean.parseBoolean(parts[3]));
        s.setLenght(Integer.parseInt(parts[2]));
        s.setLatinName(parts[1]);
        s.setName(parts[0]);
        s.setpHmin(Double.parseDouble(parts[6]));
        s.setpHmax(Double.parseDouble(parts[7]));
        s.setTempMin(Integer.parseInt(parts[8]));
        s.setTempMax(Integer.parseInt(parts[9]));
        return s;
    }

}
