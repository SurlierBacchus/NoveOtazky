import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O3 {
    public static void main(String[] args) {
        new O3();
    }

    private JLabel text;
    private JButton novaHraButton;
    private JButton cervenyButton;
    private JButton modryButton;
    private JButton ruzovyButton;
    private JButton zelenyButton;
    private JPanel mainPanel;

    private int cas;
    private int cislo = -1;

    private O3(){
        DrawHelper.initializeDefaultFrame("Pyrotechnik", 480, 240, mainPanel);

        novaHraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cislo = (int) (4.0 * Math.random());

                System.out.println(cislo);

                cas = 10;
                text.setText(String.valueOf(cas));

                if (!timer.isAlive()) {
                    timer.start();
                }
            }
        });

        cervenyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cislo == -1) return;

                if (cislo == 0) vyhralSi();
                else prehralSi();
            }
        });

        modryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cislo == -1) return;

                if (cislo == 1) vyhralSi();
                else prehralSi();
            }
        });

        ruzovyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cislo == -1) return;

                if (cislo == 2) vyhralSi();
                else prehralSi();
            }
        });

        zelenyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cislo == -1) return;

                if (cislo == 3) vyhralSi();
                else prehralSi();
            }
        });
    }

    private void vyhralSi(){
        cislo = -1;
        text.setText("Zachranil si Zem!");
    }

    private void prehralSi(){
        cislo = -1;
        text.setText("Bomba vybuchla!");
    }

    private Thread timer = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }

                if (cislo == -1) continue;

                cas--;
                text.setText(String.valueOf(cas));

                if (cas == 0){
                    prehralSi();
                }
            }
        }
    });
}
