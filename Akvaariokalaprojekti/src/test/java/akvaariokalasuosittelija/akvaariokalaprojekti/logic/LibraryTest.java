/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.logic;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import akvaariokalasuosittelija.akvaariokalaprojekti.logic.Library;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;

/**
 *
 * @author autair
 */
public class LibraryTest {

    Library l;
    File fishlist;
    Scanner s;
    Species species;

    @Before
    public void setUp() {
        l = new Library();
        File fishlist = new File("fishlist.txt");
        try {
            s = new Scanner(fishlist);
        } catch (Exception e) {
            s = null;
        }
        l.setScanner(s);
        String line = s.nextLine();
        String[] parts = line.split(";");
        species = new Species();
        species.setAqMinSize(Integer.parseInt(parts[5]));
        species.setFloor(parts[4]);
        species.setIsSocial(Boolean.parseBoolean(parts[3]));
        species.setLenght(Integer.parseInt(parts[2]));
        species.setLatinName(parts[1]);
        species.setName(parts[0]);
        species.setpHmin(Double.parseDouble(parts[6]));
        species.setpHmax(Double.parseDouble(parts[7]));
        species.setTempMin(Integer.parseInt(parts[8]));
        species.setTempMax(Integer.parseInt(parts[9]));

    }

    @Test
    public void speciesIsGeneratedTest1() {
        assertEquals(species.isSocial, true);

    }

    @Test
    public void speciesIsGeneratedTest2() {
        assertEquals(species.getName(), "marmoritapparakala");

    }

    @Test
    public void speciesIsGeneratedTest3() {
        assertEquals(4, species.getLenght());

    }

    @Test
    public void fishListIsEmptyIfVolumeSmallerThanZero() {
        l.generateFirstFishlist(-12);
        assertEquals(true, l.getCurrentList().isEmpty());
    }

    @Test
    public void fishListIsEmptyIfVolumeIsZero() {
        l.generateFirstFishlist(0);
        assertEquals(true, l.getCurrentList().isEmpty());
    }

    @Test
    public void fishListIsEmptyIfVolumeTooSmall() {
        l.generateFirstFishlist(10);
        assertEquals(true, l.getCurrentList().isEmpty());
    }

    @Test
    public void fishListIsNotGeneratedWhenAquariumIsSmallerThan25Litres() {
        l.generateFirstFishlist(24);
        assertEquals(true, l.getCurrentList().isEmpty());

    }

    @Test
    public void speciesIsAddedToCurrentList() {
        l.generateFirstFishlist(25);
        assertEquals(1, l.getCurrentList().size());
    }

    @Test
    public void severalSpeciesIsAddedToCurrentList() {
        l.generateFirstFishlist(63);
        assertEquals(8, l.getCurrentList().size());
    }

    @Test
    public void allSpeciesAddedIfAquariumIsaPool() {
        l.generateFirstFishlist(10000);
        assertEquals(l.listOfAllSpecies().size(), l.getCurrentList().size());
    }

}
