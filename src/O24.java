import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class O24 {
    public static void main(String[] args) {
        new O24();
    }

    private JPanel mainPanel;
    private JTextArea output;
    private JTextArea odTextArea;
    private JTextArea doTextArea;
    private JButton generujButton;

    private O24() {
        DrawHelper.initializeDefaultFrame("ASCII", 240, 480, mainPanel);

        generujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int odHodnota, doHodnota;
                try {
                    odHodnota = Integer.parseInt(odTextArea.getText());
                    doHodnota = Integer.parseInt(doTextArea.getText());
                } catch (NumberFormatException ex){
                    ex.printStackTrace();
                    return;
                }

                output.setText("");
                PrintWriter printWriter;
                try {
                    printWriter = new PrintWriter(new File("maturita/24/vystup.txt"));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    return;
                }

                for (int i = odHodnota; i <= doHodnota; i++){
                    output.append(i + " -> " + (char) i + "\n");
                    printWriter.println(i + " -> " + (char) i);
                }
                printWriter.close();
            }
        });
    }
}
