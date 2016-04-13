
package akvaariokalasuosittelija.akvaariokalaprojekti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessageListener implements ActionListener {
    private JTextField size;
    private int aqsize;
    private FishReferee f;
    private Library l;
    private Aquarium a;
    
    public MessageListener(JTextField size) {
        this.size = size;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
        this.aqsize = (Integer.parseInt(this.size.getText()));
        
        } catch (NumberFormatException e) { //käyttäjä syöttää muuta kuin numeroita
            System.out.println("Miten saadaan tämä teksti itse ohjelmaan näkyville");
            System.out.println("Ja niin ettei eteenpäin mennä jos homma on väärin");
        }
        this.a = new Aquarium(this.aqsize);
        this.l = new Library();
        this.f = new FishReferee(l.generateFirstFishlist(aqsize),this.a);
        this.f.firstLists();
        this.f.printCurrentLists();
    }
}