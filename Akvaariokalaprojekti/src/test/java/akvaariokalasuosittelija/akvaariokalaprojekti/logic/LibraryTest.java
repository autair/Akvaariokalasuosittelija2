/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.logic;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;

/**
 *
 * @author autair
 */
/**
 * Test class for Library.
 */
public class LibraryTest {

    Library l;
    Species species;

    @Before
    public void setUp() {
        l = new Library("fishlist.txt");
    }

    @Test
    public void speciesIsGeneratedTest1() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(species.isSocial, true);

    }

    @Test
    public void speciesIsGeneratedTest2() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(species.getName(), "marmoritapparakala");

    }

    @Test
    public void speciesIsGeneratedTest3() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(4, species.getLenght());

    }

    @Test
    public void speciesIsGeneratedTest4() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals("Carnegiella strigata", species.getLatinName());

    }

    @Test
    public void speciesIsGeneratedTest5() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals("top", species.getFloor());

    }

    @Test
    public void speciesIsGeneratedTest6() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(63, species.getaqMinSize());

    }

    @Test
    public void speciesIsGeneratedTest7() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(5, 5, species.getMinpH());

    }

    @Test
    public void speciesIsGeneratedTest8() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(7, 0, species.getMaxpH());

    }

    @Test
    public void speciesIsGeneratedTest9() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(22, species.getTempMin());

    }

    @Test
    public void speciesIsGeneratedTest10() {
        l.generateFirstFishlist(100);
        species = l.getCurrentList().get(0);
        assertEquals(28, species.getTempMax());

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
        assertEquals(11, l.getCurrentList().size());
    }

}
