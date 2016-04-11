/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akvaariokalasuosittelija.akvaariokalaprojekti;

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
    Fish fish;
    Species testspecies;
    
    
    @Before
    public void setUp() {
        a = new Aquarium(100);
        l = new Library();
        f = new FishReferee(l.generateFirstFishlist(a.getVolume()),a);
        testspecies = (Species)f.getAllList().get(0);
    }
    
//    @Test
//    public void fishCountWorks() {
//        f.updateAllSpeciesList(testspecies);
//        f.makeFinalList(); //tämä ei toimi!!!! 
//        fish = (Fish)f.getSelectedFish().get(0); //marmoritappara, 4cm
//        System.out.println(fish.getSpecies().getName());
//        assertEquals(23, fish.getAmount()); 
//    }
    
    
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
