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
    
    
    @Before
    public void setUp() {
        a = new Aquarium(100);
        l = new Library();
        f = new FishReferee(l.generateFirstFishlist(a.getVolume()),a);
    }
    
    @Test
    public void fishCountWorks() {
        f.getSelectedFish().add(f.getAllList().indexOf(5));
        f.makeFinalList(); //Tässä on joku vika
        Fish fish = (Fish)f.getSelectedFish().get(0);
        assertEquals(20,fish.getAmount());
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
