/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.logic;

import akvaariokalasuosittelija.akvaariokalaprojekti.logic.Library;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Aquarium;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Fish;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import akvaariokalasuosittelija.akvaariokalaprojekti.logic.FishReferee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author autair
 */
public class FishReferee2Test {

    public FishReferee2Test() {
    }

    Library l;
    FishReferee f;
    Aquarium a;
    Fish fish1;
    Fish fish2;
    Species testspecies1;
    Species testspecies2;

    @Before
    public void setUp() {
        a = new Aquarium(100);
        l = new Library();
        f = new FishReferee(l.generateFirstFishlist(a.getVolume()), a);
        testspecies1 = (Species) f.getAllList().get(0); //marmoritapparakala, 4cm, social
        testspecies2 = (Species) f.getAllList().get(1); //taistelukala, not social
    }

    @Test
    public void socialFishCountWorks() {
        f.updateAllSpeciesList(testspecies1);
        f.makeFinalList();
        fish1 = (Fish) f.getSelectedFish().get(0); //marmoritappara, 4cm
        System.out.println(fish1.getSpecies().getName());
        assertEquals(24, fish1.getAmount());
    }

    @Test
    public void antiSocialFishCountWorks() {
        f.updateAllSpeciesList(testspecies2);
        f.makeFinalList();
        fish2 = (Fish) f.getSelectedFish().get(0); //taistelukala, 7cm, ei sosiaalinen
        System.out.println(fish2.getSpecies().getName());
        assertEquals(1, fish2.getAmount());
    }

    @Test
    public void fishCountWorksWhenSeveralSpeciesSelected() {
        f.updateAllSpeciesList(testspecies1);
        f.updateAllSpeciesList(testspecies2);
        f.makeFinalList();

        fish1 = (Fish) f.getSelectedFish().get(0);
        fish2 = (Fish) f.getSelectedFish().get(1);
        System.out.println(fish1.getSpecies().getName() + " " + fish1.getAmount());
        System.out.println(fish2.getSpecies().getName() + " " + fish2.getAmount());
        assertEquals(24, fish1.getAmount() + fish2.getAmount());

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
