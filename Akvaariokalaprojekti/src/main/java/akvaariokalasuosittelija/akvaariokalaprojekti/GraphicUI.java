package akvaariokalasuosittelija.akvaariokalaprojekti;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GraphicUI implements Runnable {

    private JFrame frame;

    public GraphicUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("Akvaariokalasuosittelija");
        frame.setPreferredSize(new Dimension(700, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        generateComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void generateComponents(Container container) {
        
        container.add(new JLabel("Tervetuloa akvaariokalasuosittelijaan! Kirjoita akvaariosi koko alla olevaan kenttään."),BorderLayout.NORTH);
        container.add(new JLabel("Huomaathan, että ohjelma ei käsittele alle 40 litran akvaarioita."));
        container.add(generateNext(), BorderLayout.SOUTH);
      


    }
    private JPanel generateNext() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JTextArea text = new JTextArea("Akvaarion koko: ");
        JTextField aqsize = new JTextField(); 
        JButton next = new JButton("Seuraava");
        next.addActionListener(new MessageListener(aqsize));
        panel.add(text);
        panel.add(aqsize);
        panel.add(next);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}