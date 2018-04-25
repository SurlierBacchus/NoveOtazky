import com.tilgnerka.draw.DrawHelper;
import com.tilgnerka.draw.shapes.Oval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class O27 {
    public static void main(String[] args) {
        new O27();
    }

    public static final int POCET_TANIEROV = 9;
    public static final int VELKOST = 50;
    public static final int PADDING = 10;

    private List<Oval> taniere;
    private int pozicia;

    private O27() {
        DrawHelper drawHelper = new DrawHelper("Taniere", 600, 100);

        int rnd = (int) (Math.random() * 9);
        System.out.println(rnd);
        pozicia = rnd * (VELKOST + PADDING) + 5 + VELKOST/2;

        taniere = new ArrayList<>(POCET_TANIEROV);
        for (int i = 0; i < POCET_TANIEROV; i++){
            Oval oval = new Oval(i * (VELKOST + PADDING) + 5, 5, VELKOST, VELKOST, Color.GREEN, true);
            drawHelper.draw(oval);
            taniere.add(oval);
        }

        drawHelper.getFrame().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();

                if (Math.abs(x - pozicia) < VELKOST/2){
                    JOptionPane.showMessageDialog(drawHelper.getFrame(), "Nasiel si listok!");
                }
                else if (x < pozicia){
                    JOptionPane.showMessageDialog(drawHelper.getFrame(), "Skus viac vpravo");
                }
                else {
                    JOptionPane.showMessageDialog(drawHelper.getFrame(), "Skus viac vlavo");
                }
            }
        });
    }
}
