import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O9 {
    public static void main(String[] args) {
        new O9();
    }

    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button;
    private JPanel mainPanel;

    private O9(){
        JFrame frame = DrawHelper.initializeDefaultFrame("Najvacsi spolocny delitel", 300, 150, mainPanel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a, b;
                try {
                    a = Integer.parseInt(textArea1.getText());
                    b = Integer.parseInt(textArea2.getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                    return;
                }
                if (a < 0 || b < 0){
                    JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                    return;
                }

                JOptionPane.showMessageDialog(frame, String.format("Najvacsi spolocny delitel %d a %d je %d", a, b, nsd(a, b)));
            }
        });
    }

    private int nsd(int a, int b){
        if (a > b) return nsd(a - b, b);
        else if (a < b) return nsd(a, b - a);
        else return a;
    }
}
