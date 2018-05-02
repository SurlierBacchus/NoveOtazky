import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O5 {
    public static void main(String[] args) {
        new O5();
    }

    private JTextArea input;
    private JButton OKButton;
    private JPanel mainPanel;

    private O5(){
        JFrame frame = DrawHelper.initializeDefaultFrame("Kalkulacka", 360, 120, mainPanel);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vstup;

                try {
                    vstup = Integer.parseInt(input.getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                    return;
                }

                boolean jeKladne = vstup >= 0;
                vstup = Math.abs(vstup);

                StringBuilder stringBuilder = new StringBuilder();

                while(vstup != 0){
                    stringBuilder.append(vstup % 2);
                    vstup /= 2;
                }

                stringBuilder.reverse();

                JOptionPane.showMessageDialog(frame, jeKladne ? "" : "-" + stringBuilder.toString());
            }
        });
    }
}
