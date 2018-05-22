import com.tilgnerka.draw.DrawHelper;
import com.tilgnerka.draw.RenderListener;
import com.tilgnerka.draw.shapes.Line;
import com.tilgnerka.draw.shapes.Oval;
import com.tilgnerka.draw.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class O22 {
    public static void main(String[] args) {
        new O22();
    }

    private JLabel bodyLabel;
    private JLabel neuspechyLabel;
    private JPanel mainPanel;

    private int body = 0;
    private int neuspechy = 0;

    public static final int VELKOST = 50;

    private O22() {
        DrawHelper drawHelper = new DrawHelper("Chytaj", 720, 480, mainPanel, DrawHelper.Position.East);

        Oval oval = new Oval((int) (Math.random() * 500), 100, VELKOST, VELKOST, Color.RED, true);
        drawHelper.draw(oval);

        drawHelper.addRenderListener(new RenderListener() {
            @Override
            public void render() {
                oval.setY(oval.getY() + 3);

                if (oval.getY() + VELKOST >= 440){
                    oval.setX((int) (Math.random() * 500));
                    oval.setY(0);

                    neuspechy++;
                    neuspechyLabel.setText(String.valueOf(neuspechy));
                }
            }
        });

        drawHelper.getRenderablePanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (x - oval.getX() < VELKOST && x - oval.getX() > 0){
                    if (y - oval.getY() < VELKOST && y - oval.getY() > 0){
                        oval.setX((int) (Math.random() * 500));
                        oval.setY(0);

                        body++;
                        bodyLabel.setText(String.valueOf(body));
                    }
                }
            }
        });
    }
}
