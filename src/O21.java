import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class O21 {
    public static void main(String[] args) {
        new O21();
    }

    private JTextArea input;
    private JButton plus;
    private JButton minus;
    private JButton krat;
    private JButton deleno;
    private JButton vysledok;
    private JButton vymaz;
    private JTextArea history;
    private JTextArea output;
    private JPanel mainPanel;

    private int temp = 0;

    private int nextOperation = 0;
    private static final int CLEAR = 0;
    private static final int PLUS = 1;
    private static final int MINUS = 2;
    private static final int KRAT = 3;
    private static final int DELENO = 4;

    private O21(){
        DrawHelper.initializeDefaultFrame("Kalkulacka", 720, 240, mainPanel);

        vymaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                history.setText("");
                output.setText("");
                temp = 0;
                nextOperation = CLEAR;
            }
        });

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int i = Integer.parseInt(input.getText());
                    processOperation(i);
                    input.setText("");
                    nextOperation = PLUS;
                } catch (NumberFormatException ignored){}
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int i = Integer.parseInt(input.getText());
                    processOperation(i);
                    input.setText("");
                    nextOperation = MINUS;
                } catch (NumberFormatException ignored){}
            }
        });

        krat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int i = Integer.parseInt(input.getText());
                    processOperation(i);
                    input.setText("");
                    nextOperation = KRAT;
                } catch (NumberFormatException ignored){}
            }
        });

        deleno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int i = Integer.parseInt(input.getText());
                    processOperation(i);
                    input.setText("");
                    nextOperation = DELENO;
                } catch (NumberFormatException ignored){}
            }
        });

        vysledok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nextOperation == CLEAR) return;

                try {
                    int i = Integer.parseInt(input.getText());
                    processOperation(i);
                    output.setText(String.valueOf(temp));
                    input.setText(String.valueOf(temp));
                    nextOperation = CLEAR;
                } catch (NumberFormatException ignored){}
            }
        });
    }

    private void processOperation(int i){
        switch (nextOperation){
            case PLUS:
                temp += i;
                history.append("+" + i);
                break;

            case MINUS:
                temp -= i;
                history.append("-" + i);
                break;

            case KRAT:
                temp *= i;
                history.append("*" + i);
                break;

            case DELENO:
                temp /= i;
                history.append("/" + i);
                break;

            case CLEAR:
            default:
                temp = i;
                history.append(String.valueOf(i));
                break;
        }
    }
}
