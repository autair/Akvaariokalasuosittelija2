package akvaariokalasuosittelija.akvaariokalaprojekti;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GraphicUI implements Runnable {

    private JFrame frame;

    public GraphicUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("Akvaariokalasuosittelija");
        frame.setPreferredSize(new Dimension(500, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
    }

    public JFrame getFrame() {
        return frame;
    }
}