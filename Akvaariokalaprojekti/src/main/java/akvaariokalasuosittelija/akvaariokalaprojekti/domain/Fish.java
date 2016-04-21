/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.domain;

/**
 *
 * @author autair
 */
/**
 * Fish can be one or a group of fish, and it has a species and an amount.
 */
public class Fish {

    private Aquarium aquarium;
    private int amount;
    private Species s;
    private int lengthOfAll;

    /**
     * Constructor.
     *
     * @param a users aquarium
     * @param s the species of the fish
     * @param amount the amount of the fish
     */
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
