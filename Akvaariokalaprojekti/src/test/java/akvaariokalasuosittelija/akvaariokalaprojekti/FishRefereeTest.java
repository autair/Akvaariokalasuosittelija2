/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author autair
 */
public class FishRefereeTest {

    FishReferee f;
    Aquarium a;
    ArrayList list;
    Species fake1;
    Species fake2;
    Species fake3;
    Species fake4;
    Species fake5;

    @Before
    public void setUp() {
        fake1 = new Species("fake1", "latinFake1", 5, true, "mid", 60, 7.5, 8.0, 15, 30);
        fake2 = new Species("fake2", "latinFake2", 5, true, "mid", 60, 6.5, 7.1, 15, 30);
        fake3 = new Species("fake3", "latinFake3", 5, false, "top", 60, 7.5, 8.0, 21, 30);
        fake4 = new Species("fake4", "latinFake4", 5, true, "mid", 60, 7.0, 8.0, 15, 20);
        fake5 = new Species("fake5", "latinFake5", 5, true, "bottom", 60, 6.5, 7.0, 15, 30);
        a = new Aquarium(100);
        this.list = new ArrayList<Species>();
        list.add(fake1);
        list.add(fake2);
        list.add(fake3);
        list.add(fake4);
        list.add(fake5);
        f = new FishReferee(list, a);
    }
    
    @Test
    public void firstListIsFormed() {
        f.firstLists();
        assertEquals(1, f.getBottomList().size());
    }

    @Test
    public void fishListIsUpdated() {
        f.updateAllSpeciesList(fake5);
        assertEquals(2, f.getSpeciesCount());
    }

    @Test
    public void topListIsFormedCorrectly() {
        f.makeTopFishList();
        assertEquals(1, f.getTopList().size());
    }

    @Test
    public void bottomListIsFormedCorrectly() {
        f.makeBottomFishList();
        assertEquals(1, f.getBottomList().size());
    }

    @Test
    public void midListIsFormedCorrectly() {
        f.makeMidFishList();
        assertEquals(3, f.getMidList().size());
    }
    @Test
    public void speciesNotInListCannotBeFound() {
        String goldfish = "goldfish";
        f.findSpecies(goldfish);
        assertEquals(5,list.size() );
    }
    @Test
    public void speciesInListCanBeFound() {
        String fake1 = "fake1";
        f.findSpecies(fake1);
        assertEquals(2, list.size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
