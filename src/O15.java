import com.tilgnerka.draw.DrawHelper;
import com.tilgnerka.draw.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O15 {
    public static void main(String[] args) {
        new O15();
    }

    public static final int VELKOST = 25;
    public static final int POCET = 7;

    private JButton kresliButton;
    private JButton posunButton;
    private JPanel mainPanel;

    private List<Color> colors;
    private int posunutie = 0;

    private O15() {
        DrawHelper drawHelper = new DrawHelper("Pole s farbami", 360, 240, mainPanel, DrawHelper.Position.East);

        colors = Arrays.asList(
                Color.RED,
                Color.YELLOW,
                Color.BLUE,
                Color.GRAY,
                Color.GREEN,
                Color.MAGENTA,
                Color.BLACK
        );

        kresliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawHelper.getShapes().clear();

                for (int i = 0; i < POCET; i++){
                    posunutie ++;
                    if (posunutie >= POCET) posunutie = 0;

                    drawHelper.draw(new Rectangle(25 + i * VELKOST, 80, VELKOST, VELKOST, colors.get(posunutie), true));
                }
            }
        });

        posunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posunutie++;
                if (posunutie >= POCET) posunutie = 0;
            }
        });
    }
}
