import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O19 {
    public static void main(String[] args) {
        new O19();
    }

    private JPanel mainPanel;
    private JTextArea input;
    private JButton otestujButton;
    private JTextArea output;

    private O19(){
        DrawHelper.initializeDefaultFrame(mainPanel);

        otestujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] chars = input.getText().toCharArray();
                int pocet = 0;

                for (char c : chars){
                    if (c == '(') pocet++;
                    else if (c == ')') pocet--;

                    if (pocet < 0) break;
                }

                output.setText(pocet == 0 ? "OK" : "Chyba");
            }
        });
    }
}
