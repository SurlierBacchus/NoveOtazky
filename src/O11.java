import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O11 {
    public static void main(String[] args) {
        new O11();
    }

    private JPanel mainPanel;
    private JTextArea input;
    private JTextArea output;
    private JTextArea search;
    private JButton searchButton;
    private JButton clearButton;

    private O11() {
        DrawHelper.initializeDefaultFrame(mainPanel);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                output.setText("");
                search.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                String[] vstup = input.getText().split(" ");

                for (String s : vstup){
                    if (s.toLowerCase().contains(search.getText().toLowerCase())){
                        output.append(s + "\n");
                    }
                }
            }
        });
    }
}
