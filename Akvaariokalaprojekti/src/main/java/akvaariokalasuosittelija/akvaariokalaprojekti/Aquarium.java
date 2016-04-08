/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti;

import java.util.ArrayList;

/**
 *
 * @author autair
 */
public class Aquarium {

    private int volume;
    private float pH;


    public Aquarium(int volume) {
        this.volume = volume;
    }


    public int getVolume() {
        return this.volume;
    }
   
}
