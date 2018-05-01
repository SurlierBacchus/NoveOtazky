import com.tilgnerka.draw.DrawHelper;
import com.tilgnerka.draw.shapes.Oval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O14 {
    public static void main(String[] args) {
        new O14();
    }

    private JPanel mainPanel;
    private JTextArea input1;
    private JTextArea input2;
    private JLabel vysledok;
    private JButton nasobButton;
    private JTextArea inputRozloz;
    private JButton rozlozButton;
    private JTextArea output;

    public static final int VELKOST = 50;

    private O14() {
        DrawHelper drawHelper = new DrawHelper("Pomocka na nasobenie", 720, 480, mainPanel, DrawHelper.Position.East);

        nasobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawHelper.getShapes().clear();

                int a, b;
                try {
                    a = Integer.parseInt(input1.getText());
                    b = Integer.parseInt(input2.getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(drawHelper.getFrame(), "Neplatny vstup");
                    return;
                }

                for (int i = 0; i < a; i++){
                    for (int j = 0; j < b; j++){
                        drawHelper.draw(new Oval(j * VELKOST, i * VELKOST, VELKOST, VELKOST, Color.RED, true));
                    }
                }
            }
        });

        rozlozButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");

                int vstup;
                try {
                    vstup = Integer.parseInt(inputRozloz.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(drawHelper.getFrame(), "Neplatny vstup");
                    return;
                }

                for (int i = 1; i <= vstup; i++){
                    if (vstup % i == 0){
                        output.append(i + " x " + vstup/i + "\n");
                    }
                }
            }
        });
    }
}
