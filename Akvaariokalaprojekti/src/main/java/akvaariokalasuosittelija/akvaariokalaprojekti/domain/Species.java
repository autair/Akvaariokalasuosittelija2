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
 * Class contains information of one species and methods to get the info.
 */
public class Species {

    private String name;
    private String latinName;
    private int lenght;
    public boolean isSocial;
    private String floor;
    private int aqMinSize;
    private double pHmin;
    private double pHmax;
    private int tempMin;
    private int tempMax;

    /**
     * Constructor.
     *
     * @param name the Finnish name of the species
     * @param latinName the Latin name of the species
     * @param lenght the length of the species
     * @param isSocial boolean if the species is social or not
     * @param floor the floor of the species; can be top, mid or bottom
     * @param aqMinSize the minimum size of aquarium the species needs
     * @param pHmin the minimum pH of the aquarium the species can live in
     * @param pHmax the maximum pH of the aquarium the species can live in
     * @param tempMin the minimum temperature of water the species needs
     * @param tempMax the maximum temperature of water the species can stand
     */
    public Species(String name, String latinName, int lenght, boolean isSocial, String floor, int aqMinSize, double pHmin, double pHmax, int tempMin, int tempMax) {
        this.name = name;
        this.latinName = latinName;
        this.lenght = lenght;
        this.isSocial = isSocial;
        this.floor = floor;
        this.aqMinSize = aqMinSize;
        this.pHmin = pHmin;
        this.pHmax = pHmax;
        this.tempMin = tempMin;
        this.tempMax = tempMax;

    }

    /**
     * Empty Constructor.
     */
    public Species() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setIsSocial(boolean isSocial) {
        this.isSocial = isSocial;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setAqMinSize(int aqMinSize) {
        this.aqMinSize = aqMinSize;
    }

    /**
     * A method for setting the minimum pH of the species.
     *
     * @param pHmin the minimum pH
     */
    public void setpHmin(double pHmin) {
        this.pHmin = pHmin;
    }

    /**
     * A method for setting the maximum pH of the species.
     *
     * @param pHmax the maximum pH
     */
    public void setpHmax(double pHmax) {
        this.pHmax = pHmax;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public String getName() {
        return this.name;
    }

    public String getLatinName() {
        return this.latinName;
    }

    public int getLenght() {
        return this.lenght;
    }

    public boolean getSocialStatus() {
        return this.isSocial;
    }

    public String getFloor() {
        return this.floor;
    }

    /**
     * A method for getting the minimum volume of aquarium the species requires.
     *
     * @return the minimum volume
     */
    public int getaqMinSize() {
        return this.aqMinSize;
    }

    public double getMinpH() {
        return this.pHmin;
    }

    public double getMaxpH() {
        return this.pHmax;
    }

    public int getTempMin() {
        return this.tempMin;
    }

    public int getTempMax() {
        return this.tempMax;
    }
}
