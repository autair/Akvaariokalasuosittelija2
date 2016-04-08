/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author autair
 */
public class UI {

    public UI() {
    }

    public void start() {

        Library lib = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Akvaarion koko: ");
        int volume = scanner.nextInt();
        if (volume < 40) {
            System.out.println("Akvaarion pitää olla vähintään 40 litraa.");
            System.out.print("Akvaarion koko: ");
            volume = scanner.nextInt();
        }
        Aquarium a = new Aquarium(volume);
        
        FishReferee f = new FishReferee(lib.generateFirstFishlist(volume), a);
        f.firstLists();
        
        f.setSpeciesCount();
        
        f.printCurrentLists();
        //allaolevaa toistetaan, kunnes lajeja ei enää ole tarjolla tai käyttäjä siirtyy eteenpäin
        System.out.println("Kirjoita mieleinen laji: ");
        String toive = scanner.nextLine();
        f.findSpecies(toive);
        f.update();
        f.printCurrentLists();
        
        
//        f.printMidList();
//        System.out.println("Valitse listalta keskiveden kalalaji: ");
//        f.upDateFishList((Species)f.getMidList().get(2));
//        f.update();
//        f.printMidList();
        
       


    }

}
