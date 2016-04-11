/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akvaariokalasuosittelija.akvaariokalaprojekti;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author autair
 */
public class LibraryTest {
    
    Library l;
    
    
    @Before
    public void setUp() {
        l = new Library();
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
    public void speciesIsAddedToList() {
        l.generateFirstFishlist(25);
        assertEquals(1, l.getCurrentList().size());
    }
    
    @Test
    public void allSpeciesAddedIfAquariumIsaPool() {
        l.generateFirstFishlist(10000);
        assertEquals(l.listOfAllSpecies().size(), l.getCurrentList().size());
    }
  
    
    
    

}
