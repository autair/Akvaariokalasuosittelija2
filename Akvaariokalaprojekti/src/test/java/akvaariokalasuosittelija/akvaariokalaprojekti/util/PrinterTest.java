/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.util;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Aquarium;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Fish;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import akvaariokalasuosittelija.akvaariokalaprojekti.logic.Library;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author autair
 */
public class PrinterTest {

    Printer p;
    ArrayList toptestlist;
    ArrayList midtestlist;
    ArrayList bottomtestlist;
    ArrayList finallist;
    Fish f;
    Aquarium a;

    @Before
    public void setUp() {
        p = new Printer();
        a = new Aquarium(45);
        toptestlist = new ArrayList<Species>();
        toptestlist.add(new Species("minirasbora", "Boraras merah", 3, true, "top", 25, 5.0, 7.0, 24, 28));
        midtestlist = new ArrayList<Species>();
        midtestlist.add(new Species("hehkutetra", "Hyphessobrycon amandae", 3, true, "mid", 33, 5.5, 7.0, 24, 28));
        bottomtestlist = new ArrayList<Species>();
        bottomtestlist.add(new Species("kääpiömonninen", "Corydoras pygmaeus", 3, true, "bottom", 45, 6.0, 7.0, 24, 27));
        finallist = new ArrayList<Fish>();
        try {
            finallist.add(new Fish(a, new Species("kääpiömonninen", "Corydoras pygmaeus", 3, true, "bottom", 45, 6.0, 7.0, 24, 27), 7));
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getInfoWorks1() {
        String testdata = p.getInfo(toptestlist, "minirasbora");
        assertEquals(testdata, "Nimi: " + "minirasbora" + "\n" + "Latinankielinen nimi: " + "Boraras merah" + "\n" + "Sosiaalisuus: " + "parvikala" + "\n" + "Akvaarion minimikoko litroissa: " + "25" + "\n" + "Uintikerros: " + "pinta" + "\n" + "Pituus cm: " + "3" + "\n" + "MinimipH: " + "5.0" + "\n" + "MaksimipH: " + "7.0" + "\n" + "Minimilämpötila: " + "24" + "\n" + "Maksimilämpötila: " + "28");

    }

    @Test
    public void getInfoWorks2() {
        String testdata = p.getInfo(midtestlist, "hehkutetra");
        assertEquals(testdata, "Nimi: " + "hehkutetra" + "\n" + "Latinankielinen nimi: " + "Hyphessobrycon amandae" + "\n" + "Sosiaalisuus: " + "parvikala" + "\n" + "Akvaarion minimikoko litroissa: " + "33" + "\n" + "Uintikerros: " + "keski" + "\n" + "Pituus cm: " + "3" + "\n" + "MinimipH: " + "5.5" + "\n" + "MaksimipH: " + "7.0" + "\n" + "Minimilämpötila: " + "24" + "\n" + "Maksimilämpötila: " + "28");

    }

    @Test
    public void getInfoWorks3() {
        String testdata = p.getInfo(bottomtestlist, "kääpiömonninen");
        assertEquals(testdata, "Nimi: " + "kääpiömonninen" + "\n" + "Latinankielinen nimi: " + "Corydoras pygmaeus" + "\n" + "Sosiaalisuus: " + "parvikala" + "\n" + "Akvaarion minimikoko litroissa: " + "45" + "\n" + "Uintikerros: " + "pohja" + "\n" + "Pituus cm: " + "3" + "\n" + "MinimipH: " + "6.0" + "\n" + "MaksimipH: " + "7.0" + "\n" + "Minimilämpötila: " + "24" + "\n" + "Maksimilämpötila: " + "27");

    }

    @Test
    public void getInfoWorks4() {
        String testdata = p.getInfo(bottomtestlist, "SHARKNADO");
        assertEquals(testdata, "");

    }

    @Test
    public void getInfoWorks5() {
        String testdata = p.getInfo(null, "kääpiömonninen");
        assertEquals(testdata, "");

    }

    @Test
    public void getAvailableSpeciesWorks() {
        String testdata = p.getAvailableSpecies(toptestlist, midtestlist, bottomtestlist);
        assertEquals(testdata, "Pintaveden kalat: " + "\n" + "minirasbora" + "\n" + "Keskiveden kalat: " + "\n" + "hehkutetra" + "\n" + "Pohjaveden kalat: " + "\n" + "kääpiömonninen");
    }

    @Test
    public void getFinalFishWorks() {
        String testdata = p.getFinalFish(finallist);
        assertEquals(testdata, "\nkääpiömonninen, 7 kpl");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
