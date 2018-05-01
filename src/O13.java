import com.tilgnerka.draw.DrawHelper;
import com.tilgnerka.draw.shapes.Oval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert Gers on 26.04.2018.
 */
public class O13 {
    public static void main(String[] args) {
        new O13();
    }

    private JButton blue;
    private JButton purple;
    private JButton red;
    private JButton pink;
    private JButton green;
    private JPanel mainPanel;
    private JButton orange;

    public static final int POCET = 8;
    public static final int VELKOST = 50;

    private DrawHelper drawHelper;
    private Color color1;
    private Color color2;
    private boolean iterator = true;

    private O13() {
        drawHelper = new DrawHelper("Sachovnica", 720, 480, mainPanel, DrawHelper.Position.West);

        color1 = Color.blue;
        color2 = Color.magenta;

        render();

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterator = !iterator;

                if (iterator) color1 = Color.blue;
                else color2 = Color.blue;

                drawHelper.getShapes().clear();
                render();
            }
        });

        purple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterator = !iterator;

                if (iterator) color1 = Color.magenta;
                else color2 = Color.magenta;

                drawHelper.getShapes().clear();
                render();
            }
        });

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterator = !iterator;

                if (iterator) color1 = Color.red;
                else color2 = Color.red;

                drawHelper.getShapes().clear();
                render();
            }
        });

        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterator = !iterator;

                if (iterator) color1 = Color.pink;
                else color2 = Color.pink;

                drawHelper.getShapes().clear();
                render();
            }
        });

        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterator = !iterator;

                if (iterator) color1 = Color.green;
                else color2 = Color.green;

                drawHelper.getShapes().clear();
                render();
            }
        });

        orange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterator = !iterator;

                if (iterator) color1 = Color.orange;
                else color2 = Color.orange;

                drawHelper.getShapes().clear();
                render();
            }
        });
    }

    private void render(){
        int x = 0, y = 0;
        for (int i = 0; i < POCET; i++){
            for (int j = 0; j < POCET; j++) {
                drawHelper.draw(new Oval(x, y, VELKOST, VELKOST, (i + j) % 2 == 0 ? color1 : color2, true));
                x += VELKOST;
            }

            x = 0;
            y += VELKOST;
        }
    }
}
