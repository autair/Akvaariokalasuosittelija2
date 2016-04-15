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

    public void setpHmin(double pHmin) {
        this.pHmin = pHmin;
    }

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