import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O12 {
    public static void main(String[] args) {
        new O12();
    }

    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton zasifrujButton;
    private JButton desifrujButton;
    private JPanel mainPanel;

    private O12(){
        DrawHelper.initializeDefaultFrame("Cezarova Sifra", 720, 480, mainPanel);

        zasifrujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vstup = textArea1.getText();
                StringBuilder vystup = new StringBuilder();

                for (int i = 0; i < vstup.length(); i++){
                    char c = vstup.charAt(i);
                    if (!Character.isLetter(c)){
                        vystup.append(c);
                        continue;
                    }

                    c = (char) ((int) c + 3);

                    if ((int) c > (int) 'z' && (int) c < (int) 'z' + 4){
                        c = (char) ((int) 'a' + ((int) c - (int) 'z') -1);
                    }
                    else if ((int) c > (int) 'Z' && (int) c < (int) 'Z' + 4){
                        c = (char) ((int) 'A' + ((int) c - (int) 'Z') -1);
                    }

                    vystup.append(c);
                }

                textArea2.setText(vystup.toString());
            }
        });

        desifrujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vstup = textArea2.getText();
                StringBuilder vystup = new StringBuilder();

                for (int i = 0; i < vstup.length(); i++){
                    char c = vstup.charAt(i);
                    if (!Character.isLetter(c)){
                        vystup.append(c);
                        continue;
                    }

                    c = (char) ((int) c - 3);

                    if ((int) c < (int) 'a' && (int) c > (int) 'a' - 4){
                        c = (char) ((int) 'z' - ((int) 'a' - (int) c) +1);
                    }
                    else if ((int) c < (int) 'A' && (int) c > (int) 'A' - 4){
                        c = (char) ((int) 'Z' - ((int) 'A' - (int) c) +1);
                    }

                    vystup.append(c);
                }

                textArea1.setText(vystup.toString());
            }
        });
    }
}
