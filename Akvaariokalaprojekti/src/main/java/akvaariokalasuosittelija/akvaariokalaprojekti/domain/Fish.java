/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.domain;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;

/**
 *
 * @author autair
 */

/**
 * Luokan ilmentymä vastaa yhtä kalaa/parvea, jolla on laji ja määrä.
 */
public class Fish {

    private Aquarium aquarium;
    private int amount;
    private Species s;
    private int lengthOfAll;

    public Fish(Aquarium a, Species s, int amount) {
        this.s = s;
        this.aquarium = a;
        this.amount = amount;
        this.lengthOfAll = this.s.getLenght() * this.amount;
    }

    public Aquarium getAquarium() {
        return this.aquarium;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public Species getSpecies() {
        return this.s;
    }

    public int getLengthOfAll() {
        return this.s.getLenght() * this.amount;
    }

}
