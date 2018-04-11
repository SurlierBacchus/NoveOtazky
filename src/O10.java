import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import javax.swing.text.EditorKit;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class O10 {

    private JButton save;
    private JButton italic;
    private JButton bold;
    private JPanel mainPanel;
    private JEditorPane text;

    private int textState = 0;
    private static final int PLAIN = 0;
    private static final int ITALIC = 1;
    private static final int BOLD = 2;

    public static void main(String[] args) {
        new O10();
    }

    private O10(){
        DrawHelper.initializeDefaultFrame(mainPanel);

        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textState == ITALIC){
                    text.setFont(text.getFont().deriveFont(Font.PLAIN));
                    textState = PLAIN;
                } else {
                    text.setFont(text.getFont().deriveFont(Font.ITALIC));
                    textState = ITALIC;
                }
            }
        });

        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textState == BOLD){
                    text.setFont(text.getFont().deriveFont(Font.PLAIN));
                    textState = PLAIN;
                }
                else {
                    text.setFont(text.getFont().deriveFont(Font.BOLD));
                    textState = BOLD;
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter printWriter = new PrintWriter("maturita/10/vystup.txt");
                    String out = "";

                    if (textState == PLAIN) out = text.getText();
                    else if (textState == ITALIC) out = "<i>" + text.getText() + "</i>";
                    else if (textState == BOLD) out = "<b>" + text.getText() + "</b>";

                    printWriter.print(out);
                    printWriter.close();

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
