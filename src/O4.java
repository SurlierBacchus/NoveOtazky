import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class O4 {
    public static void main(String[] args) {
        new O4();
    }

    private JSlider redSlider;
    private JTextArea redValue;
    private JSlider greenSlider;
    private JTextArea greenValue;
    private JSlider blueSlider;
    private JTextArea blueValue;
    private JPanel out;
    private JPanel mainPanel;

    private O4(){
        JFrame frame = DrawHelper.initializeDefaultFrame("RGB", 540, 180, mainPanel);
        setColor();

        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redValue.setText(String.valueOf(redSlider.getValue()));

                setColor();
            }
        });

        redValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    e.consume();

                    int hodnota;
                    try {
                        hodnota = Integer.parseInt(redValue.getText());
                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                        return;
                    }
                    redSlider.setValue(hodnota);

                    setColor();
                }
            }
        });


        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenValue.setText(String.valueOf(greenSlider.getValue()));

                setColor();
            }
        });

        greenValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    e.consume();

                    int hodnota;
                    try {
                        hodnota = Integer.parseInt(greenValue.getText());
                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                        return;
                    }
                    greenSlider.setValue(hodnota);

                    setColor();
                }
            }
        });


        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueValue.setText(String.valueOf(blueSlider.getValue()));

                setColor();
            }
        });


        blueValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    e.consume();

                    int hodnota;
                    try {
                        hodnota = Integer.parseInt(blueValue.getText());
                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                        return;
                    }
                    blueSlider.setValue(hodnota);

                    setColor();
                }
            }
        });
    }

    private void setColor(){
        out.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
    }
}
