import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O29 {
    public static void main(String[] args) {
        new O29();
    }

    private JButton rovnakeButton;
    private JLabel label1;
    private JLabel label2;
    private JPanel mainPanel;

    private boolean jeZapnuta = false;

    private O29() {
        JFrame frame = DrawHelper.initializeDefaultFrame("Videostop", 200, 120, mainPanel);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (!jeZapnuta) continue;

                    label1.setText(String.valueOf((int) (Math.random() * 9)));
                    label2.setText(String.valueOf((int) (Math.random() * 9)));

                }
            }
        }).start();

        rovnakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jeZapnuta) {
                    rovnakeButton.setText("Rovnake?");
                    jeZapnuta = true;
                    return;
                }

                int a = Integer.parseInt(label1.getText());
                int b = Integer.parseInt(label2.getText());

                if (a == b) {
                    jeZapnuta = false;
                    JOptionPane.showMessageDialog(frame, "Vyhral si!");
                    rovnakeButton.setText("Nova Hra");
                }
            }
        });
    }
}
