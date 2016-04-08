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
    public void fishListIsEmptyIfVolumeTooSmall() {
        l.generateFirstFishlist(10);
        assertEquals(true, l.getCurrentList().isEmpty());
    }
    
    @Test
    public void fishIsAddedToList() {
        int aqMinSize = 25;
        l.generateFirstFishlist(aqMinSize);
        assertEquals(1, l.getSpeciesCount());
    }
  
    
    
    

}
