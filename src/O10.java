import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O10 {

    private JButton save;
    private JButton italic;
    private JButton bold;
    private JPanel mainPanel;
    private JEditorPane text;

    private boolean isItalic = false;
    private boolean isBold = false;

    public static void main(String[] args) {
        new O10();
    }

    private O10(){
        DrawHelper.initializeDefaultFrame(mainPanel);
        text.setContentType("text/html");
        text.setText("<p>");

        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isItalic){
                    text.setText(text.getText() + "</i>");
                } else {
                    text.setText(text.getText() + "<i>");
                }

                isItalic = !isItalic;
            }
        });

        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isBold){
                    text.setText(text.getText() + "</b>");
                } else {
                    text.setText(text.getText() + "<b>");
                }

                isBold = !isBold;
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
