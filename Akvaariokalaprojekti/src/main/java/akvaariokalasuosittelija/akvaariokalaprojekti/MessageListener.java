
package akvaariokalasuosittelija.akvaariokalaprojekti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Seuraavaa on klikattu juu");
    }
}