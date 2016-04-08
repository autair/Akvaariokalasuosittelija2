/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvaariokalasuosittelija.akvaariokalaprojekti;

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
    private Aquarium a;
    private int speciesCount;
    private int currentSpeciesCount;
    

    public FishReferee(ArrayList list, Aquarium a) {
        this.list = list;
        this.toplist = new ArrayList();
        this.midlist = new ArrayList();
        this.bottomlist = new ArrayList();
        this.selectedFish = new ArrayList();
        this.a = a;
        this.currentSpeciesCount = 0;
    }
    
    public void firstLists() {
        this.makeBottomFishList();
        this.makeMidFishList();
        this.makeTopFishList();
    }

    public String update() {
        
        if (this.bottomlist.isEmpty() && this.midlist.isEmpty() && this.toplist.isEmpty() || this.getLengthOfSelectedFish() + 10 > this.a.getVolume() || this.speciesCount == this.currentSpeciesCount) {
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
        try {
            for (Fish x : this.selectedFish) {
                i = i + x.getLengthOfAll();
            }
        } catch (Exception NullPointerException) {
            System.out.println("Lista on tyhjä.");
        }
        return i;
    }

    public void printMidList() {
        for (Species s : this.midlist) {
            System.out.println(s.getName());
        }
    }

    public void setSpeciesCount() {
        if (this.a.getVolume() < 100) {
            this.speciesCount = 3;
        } else {
            this.speciesCount = 6;
        }
    }

    public int getSpeciesCount() {
        return this.list.size();
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
        Iterator<Species> i = this.list.iterator();

        while (i.hasNext()) {
            Species x = i.next();

            if (x.isSocial == true && this.getLengthOfSelectedFish() + x.getLenght() * 7 > this.a.getVolume()) {
                i.remove();
            }
            if (x.isSocial == false && this.getLengthOfSelectedFish() + x.getLenght() > this.a.getVolume()) {
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
            Fish fish = new Fish(a, s, 7);
            this.selectedFish.add(fish);
            this.currentSpeciesCount = this.currentSpeciesCount + 1;
        }
        if (s.isSocial == false) {
            Fish fish = new Fish(a, s, 1);
            this.selectedFish.add(fish);
            this.currentSpeciesCount = this.currentSpeciesCount + 1;
        }

        this.list.remove(s);

        return this.list;

    }

    public void findSpecies(String name) {

        try {
            for (Species x : this.list) {
                if (x.getName().equals(name)) {
                    this.updateAllSpeciesList(x);
                }
            }
           
        } catch (Exception NullPointerException) {
            System.out.println("Lista on tyhjä.");
        }
        
    }
    
    //tee metodi joka laskee valittujen lajien määrään akvaarion kokoon sopivaksi. 
    //Käyttäjä voi siis "valita akvaarion täyteen" tai valita vaikka 3 lajia, joiden määrää metodin pitää kasvattaa.
    
    public void makeFinalList() {
        while(true) {
            for (Fish x:this.selectedFish) {
                if (this.getLengthOfSelectedFish() + 5 > this.a.getVolume()) {
                    break;
                }
                if(x.getSpecies().isSocial == true) {
                    if (this.getLengthOfSelectedFish() + x.getSpecies().getLenght() < this.a.getVolume()) {
                        x.setAmount(x.getAmount() + 1);
                    }
                }
            }
            break;
        }
    }
    

    public void printCurrentLists() {
        try {
            System.out.println("Pohjaveden lajit: ");
            for (Species s : this.bottomlist) {
                System.out.println(s.getName());
            }

        } catch (Exception NullPointerException) {
            System.out.println("Lista on tyhjä.");
        }
        try {
            System.out.println("Keskiveden lajit: ");
            for (Species s : this.midlist) {
                System.out.println(s.getName());
            }

        } catch (Exception NullPointerException) {
            System.out.println("Lista on tyhjä.");
        }
        try {
            System.out.println("Pintaveden lajit: ");
            for (Species s : this.toplist) {
                System.out.println(s.getName());
            }

        } catch (Exception NullPointerException) {
            System.out.println("Lista on tyhjä.");
        }

    }

}
