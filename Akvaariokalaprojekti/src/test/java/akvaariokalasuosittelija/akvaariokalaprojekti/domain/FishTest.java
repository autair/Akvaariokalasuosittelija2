/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.domain;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Aquarium;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Fish;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
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
public class FishTest {

    public FishTest() {
    }

    Species s;
    Fish f;
    Aquarium a;

    @Before
    public void setUp() {
        s = new Species("seeprakala", "Danio rerio", 5, true, "mid", 70, 6.5, 7.0, 20, 28);
        a = new Aquarium(100);
        f = new Fish(a,s,7);
    }
    
    @Test
    public void returnCorrectSpecies() {
        assertEquals("seeprakala", f.getSpecies().getName());
    }
    
    @Test
    public void returnCorrectAmount() {
        assertEquals(7,f.getAmount());
    }

}
