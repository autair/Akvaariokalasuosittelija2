/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.logic;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import java.util.Iterator;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author autair
 */
public class Library {

    private File fishlist;
    private Scanner scanner;
    private ArrayList<Species> list;
    private ArrayList<Species> all;
    private int aqSize;

    public Library() {
        this.list = new ArrayList();
        //this.all = new ArrayList();
        this.aqSize = 0;

    }
    
    public void setScanner(Scanner s) {
        this.scanner = s;
    }

    public ArrayList listOfAllSpecies() {
        this.all = new ArrayList<Species>();

        File fishlist = new File("fishlist.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(fishlist);
        } catch (Exception e) {
            System.out.println("Kirjaston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return null;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(";");
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

            this.all.add(s);

        }

        scanner.close();
        return this.all;

    }

    public ArrayList getCurrentList() {
        return this.list;
    }

    public ArrayList generateFirstFishlist(int aqVolume) {
        if (aqVolume <= 24) {
            System.out.println("Akvaarion tilavuus ei voi olla negatiivinen eikä alle 25 litraa");
            return null;
        }
        File fishlist = new File("fishlist.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(fishlist);
        } catch (Exception e) {
            System.out.println("Kirjaston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return null;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(";");
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

            if (s.getaqMinSize() <= aqVolume) {
                this.list.add(s);
            }

        }
        if (this.list.isEmpty()) {
            System.out.println("Näin pieneen akvaarioon ei voi laittaa kaloja.");
            return null;
        }

        scanner.close();

        return this.list;
    }

}
