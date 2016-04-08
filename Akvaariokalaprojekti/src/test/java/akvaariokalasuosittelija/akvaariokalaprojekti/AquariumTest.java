package akvaariokalasuosittelija.akvaariokalaprojekti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author autair
 */
public class AquariumTest {

    

    Aquarium a;

    @Before
    public void setUp() {
        a = new Aquarium(100);
    }

    @Test
    public void returnsCorrectVolume() {
        assertEquals(100, a.getVolume());
    }

}
