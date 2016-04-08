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
public class SpeciesTest {

    public SpeciesTest() {
    }

    Species s;

    @Before
    public void setUp() {
        s = new Species("seeprakala", "Danio rerio", 5, true, "mid", 70, 6.5, 7.0, 20, 28);
    }

    @Test
    public void returnsCorrectName() {
        assertEquals("seeprakala", s.getName());
    }

    @Test
    public void returnsCorrectLatinName() {
        assertEquals("Danio rerio", s.getLatinName());
    }

    @Test
    public void returnsCorrectLength() {
        assertEquals(5, s.getLenght());
    }

    @Test
    public void returnsCorrectSocialStatus() {
        assertEquals(true, s.getSocialStatus());
    }

    @Test
    public void returnsCorrectFloor() {
        assertEquals("mid", s.getFloor());
    }

    @Test
    public void returnsCorrectAquariumMinSize() {
        assertEquals(70, s.getaqMinSize());
    }

    @Test
    public void returnsCorrectMinpH() {
        assertEquals(6, 5, s.getMinpH());
    }

    @Test
    public void returnsCorrectMaxpH() {
        assertEquals(7, 0, s.getMaxpH());
    }

}
