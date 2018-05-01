import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class O2 {
    public static void main(String[] args) {
        new O2();
    }

    private JPanel mainPanel;
    private JTextArea input;
    private JButton button;
    private JTextArea output;

    private List<Integer> prvocisla;

    private O2(){
        JFrame frame = DrawHelper.initializeDefaultFrame("Prvocisla", 240, 480, mainPanel);

        prvocisla = new ArrayList<>();
        prvocisla.add(2);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");

                int vstup;
                try {
                    vstup = Integer.parseInt(input.getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Neplatny vstup");
                    return;
                }

                for (int i = prvocisla.get(prvocisla.size()-1); i <= vstup; i++){
                    boolean je = true;

                    for (int j = 0; j < prvocisla.size(); j++){
                        if (i % prvocisla.get(j) == 0) {
                            je = false;
                            break;
                        }
                    }

                    if (je) prvocisla.add(i);
                }

                for (int i = 0; i < prvocisla.size() && prvocisla.get(i) <= vstup; i++){
                    output.append(prvocisla.get(i) + "\n");
                }
            }
        });
    }
}
