import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O6 {
    public static void main(String[] args) {
        new O6();
    }

    private JTextArea textArea1;
    private JButton doDECButton;
    private JPanel mainPanel;

    private O6() {
        JFrame frame = DrawHelper.initializeDefaultFrame("Bin to Dec", 360, 200, mainPanel);

        doDECButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] input = textArea1.getText().toCharArray();
                int vysledok = 0;

                for (int i = 0; i < input.length; i++) {
                    if (input[i] == '1'){
                        vysledok += Math.pow(2, input.length - i -1);
                    }
                    else if (input[i] != '0'){
                        JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                        return;
                    }
                }

                JOptionPane.showMessageDialog(frame, String.valueOf(vysledok));
            }
        });
    }
}
