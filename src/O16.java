import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O16 {
    public static void main(String[] args) {
        new O16();
    }

    public static final int KAMEN = 0;
    public static final int PAPIER = 1;
    public static final int NOZNICE = 2;

    public static final int VYHRA = 1;
    public static final int REMIZA = 0;
    public static final int PREHRA = 2;

    public static final String[] nazvy = new String[]{
            "Kamen", "Papier", "Noznice"
    };

    private JTextArea textArea;
    private JButton kamenButton;
    private JButton papierButton;
    private JButton nozniceButton;
    private JButton novaHraButton;
    private JLabel label1;
    private JLabel label2;
    private JPanel mainPanel;

    private int skoreJa = 0;
    private int skorePc = 0;

    private O16(){
        DrawHelper.initializeDefaultFrame("Kamen Papier Noznice", 520, 380, mainPanel);

        kamenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Kamen");
                int pc = (int) (Math.random() * 3);
                label2.setText(nazvy[pc]);

                int vysledok = vysledok(KAMEN, pc);
                if (vysledok == VYHRA){
                    skoreJa++;
                    textArea.append(String.format("Vyhral si!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
                else if (vysledok == REMIZA){
                    textArea.append(String.format("Remiza!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
                else {
                    skorePc++;
                    textArea.append(String.format("Prehral si!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
            }
        });
        papierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Papier");
                int pc = (int) (Math.random() * 3);
                label2.setText(nazvy[pc]);

                int vysledok = vysledok(PAPIER, pc);
                if (vysledok == VYHRA){
                    skoreJa++;
                    textArea.append(String.format("Vyhral si!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
                else if (vysledok == REMIZA){
                    textArea.append(String.format("Remiza!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
                else {
                    skorePc++;
                    textArea.append(String.format("Prehral si!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
            }
        });
        nozniceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Noznice");
                int pc = (int) (Math.random() * 3);
                label2.setText(nazvy[pc]);

                int vysledok = vysledok(NOZNICE, pc);
                if (vysledok == VYHRA){
                    skoreJa++;
                    textArea.append(String.format("Vyhral si!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
                else if (vysledok == REMIZA){
                    textArea.append(String.format("Remiza!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
                else {
                    skorePc++;
                    textArea.append(String.format("Prehral si!\nStav: %d:%d\n******************\n", skoreJa, skorePc));
                }
            }
        });

        novaHraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");

                skoreJa = 0;
                skorePc = 0;

                label1.setText("");
                label2.setText("");
            }
        });
    }

    private int vysledok(int ja, int pc){
        switch (ja){
            case KAMEN:
                if (pc == NOZNICE) return VYHRA;
                if (pc == PAPIER) return PREHRA;
                return REMIZA;

            case PAPIER:
                if (pc == KAMEN) return VYHRA;
                if (pc == NOZNICE) return PREHRA;
                return REMIZA;

            case NOZNICE:
                if (pc == PAPIER) return VYHRA;
                if (pc == KAMEN) return PREHRA;
                return REMIZA;
        }

        return -1;
    }
}
