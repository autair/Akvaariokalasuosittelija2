/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti.logic;

import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Aquarium;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Fish;
import akvaariokalasuosittelija.akvaariokalaprojekti.domain.Species;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author autair
 */
public class FishReferee {

    private ArrayList<Species> list;
    private ArrayList<Species> toplist;
    private ArrayList<Species> midlist;
    private ArrayList<Species> bottomlist;
    private ArrayList<Fish> selectedFish;
    private Aquarium aquarium;
    private int speciesCount;
    private int currentSpeciesCount;

    public FishReferee(ArrayList list, Aquarium a) {
        this.list = list;
        this.toplist = new ArrayList();
        this.midlist = new ArrayList();
        this.bottomlist = new ArrayList();
        this.selectedFish = new ArrayList();
        this.aquarium = a;
        this.currentSpeciesCount = 0;
    }

    public void firstLists() {
        this.makeBottomFishList();
        this.makeMidFishList();
        this.makeTopFishList();
    }

    public void setSelected(ArrayList lis) {
        this.selectedFish = lis;
    }

    public String update() {

        if (this.bottomlist.isEmpty() && this.midlist.isEmpty() && this.toplist.isEmpty() || this.getLengthOfSelectedFish() + 5 > this.aquarium.getVolume() || this.speciesCount == this.currentSpeciesCount) {
            return "stop";
        }

        this.makeBottomFishList();
        this.makeMidFishList();
        this.makeTopFishList();
        return "continue";

    }

    public void makeMidFishList() {
        this.midlist = new ArrayList<>();
        for (Species x : this.list) {
            if (x.getFloor().equals("mid")) {
                this.midlist.add(x);
            }
        }
    }

    public void makeTopFishList() {
        this.toplist = new ArrayList<>();
        for (Species x : this.list) {
            if (x.getFloor().equals("top")) {
                this.toplist.add(x);
            }
        }
    }

    public void makeBottomFishList() {
        this.bottomlist = new ArrayList<>();
        for (Species x : this.list) {
            if (x.getFloor().equals("bottom")) {
                this.bottomlist.add(x);
            }
        }
    }

    public int getLengthOfSelectedFish() {
        int i = 0;
        if (this.selectedFish.isEmpty()) {
            return i;
        }
        for (Fish x : this.selectedFish) {
            i = i + x.getLengthOfAll();
        }
        return i;
    }

    public void setSpeciesCount() {
        if (this.aquarium.getVolume() < 100) {
            this.speciesCount = 3;
        } else {
            this.speciesCount = 6;
        }
    }

    public int getSpeciesCount() {
        return this.list.size();
    }

    public ArrayList getSpeciesList() {
        return this.list;
    }

    public ArrayList getSelectedFish() {
        return this.selectedFish;
    }

    public ArrayList getMidList() {
        return this.midlist;
    }

    public ArrayList getBottomList() {
        return this.bottomlist;
    }

    public ArrayList getTopList() {
        return this.toplist;
    }

    public ArrayList getAllList() {
        return this.list;
    }

    public ArrayList updateAllSpeciesList(Species s) {
        ArrayList nList = (ArrayList) this.list.clone();
        Iterator<Species> i = nList.iterator();

        while (i.hasNext()) {
            Species x = i.next();

            if (x.isSocial == true && this.getLengthOfSelectedFish() + x.getLenght() * 7 > this.aquarium.getVolume()) {
                i.remove();
            }
            if (x.isSocial == false && this.getLengthOfSelectedFish() + x.getLenght() > this.aquarium.getVolume()) {
                i.remove();
            }

            if (x.getTempMin() > s.getTempMax()) {
                i.remove();
            }
            if (x.getaqMinSize() > s.getaqMinSize()) {
                i.remove();
            }
            if (x.getMinpH() > s.getMaxpH()) {
                i.remove();
            }
            if (x.getMaxpH() < s.getMinpH()) {
                i.remove();
            }
            if (x.getTempMax() < s.getTempMin()) {
                i.remove();
            }

        }
        if (s.isSocial == true) {
            Fish fish = new Fish(this.aquarium, s, 7);
            this.selectedFish.add(fish);
            this.currentSpeciesCount = this.currentSpeciesCount + 1;
        }
        if (s.isSocial == false) {
            Fish fish = new Fish(this.aquarium, s, 1);
            this.selectedFish.add(fish);
            this.currentSpeciesCount = this.currentSpeciesCount + 1;
        }

        nList.remove(s);

        this.list = nList;
        return nList;

    }

    public void findSpecies(String name) {

        try {
            for (Species x : this.list) {
                if (x.getName().equals(name)) {
                    this.updateAllSpeciesList(x);
                    break;
                }
            }

        } catch (NullPointerException e) {
            System.out.println("Lista on tyhjä.");
        }

    }

    public void makeFinalList() {

        int stop = 0;
        int countOfSocialFish = 0;

        for (Fish fish : this.selectedFish) {
            if (fish.getSpecies().isSocial) {
                countOfSocialFish = countOfSocialFish + 1;
            }
        }
        if (countOfSocialFish == 0) {
            stop = 5;
        }

        while (stop != 5) {

            int sumLength = getLengthOfSelectedFish() + 5;
            int aqVolume = this.aquarium.getVolume();

            for (Fish f : this.selectedFish) {
                if (f.getSpecies().isSocial) {
                    f.setAmount((Integer) f.getAmount() + 1);
                }

                if (sumLength > aqVolume) {
                    f.setAmount(f.getAmount() - 1);
                    stop = 5;
                    break;
                }

            }

        }
    }
}
