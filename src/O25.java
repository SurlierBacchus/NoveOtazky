import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class O25 {
    public static void main(String[] args) {
        new O25();
    }

    private JPanel mainPanel;
    private JTextArea datumVstup;
    private JTextArea casVstup;
    private JLabel rok;
    private JLabel mesiac;
    private JLabel tyzden;
    private JLabel den;
    private JLabel hodina;
    private JLabel minuta;
    private JLabel sekunda;
    private JLabel cas;
    private JButton vypocitajButton;

    private O25() {
        JFrame frame = DrawHelper.initializeDefaultFrame("Datum narodenia", 720, 300, mainPanel);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        vypocitajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datum = datumVstup.getText();
                String cas = casVstup.getText();
                Date teraz = new Date();

                try {
                    Date narodenie = dateFormat.parse(datum + " " + cas);
                    System.out.println(dateFormat.format(narodenie));

                    int rokH = teraz.getYear() - narodenie.getYear();

                    int mesiacH = teraz.getMonth() - narodenie.getMonth();
                    if (mesiacH < 0){
                        rokH--;
                        mesiacH = 12 + mesiacH;
                    }

                    int denH = teraz.getDate() - narodenie.getDate();
                    if (denH < 0){
                        mesiacH--;
                        denH = 30 + denH;
                    }
                    int tyzdenH = denH / 7;
                    denH %= 7;

                    int hodH = teraz.getHours() - narodenie.getHours();
                    if (hodH < 0){
                        denH--;
                        hodH = 24 + hodH;
                    }

                    int minH = teraz.getMinutes() - narodenie.getMinutes();
                    if (minH < 0){
                        hodH--;
                        minH = 60 + minH;
                    }

                    int sekH = teraz.getSeconds() - narodenie.getSeconds();
                    if (sekH < 0){
                        minH--;
                        sekH = 60 + sekH;
                    }

                    if (rokH < 0){
                        JOptionPane.showMessageDialog(frame, "Vstup je neskor ako teraz");
                    }

                    rok.setText(String.valueOf(rokH));
                    mesiac.setText(String.valueOf(mesiacH));
                    tyzden.setText(String.valueOf(tyzdenH));
                    den.setText(String.valueOf(denH));
                    hodina.setText(String.valueOf(hodH));
                    minuta.setText(String.valueOf(minH));
                    sekunda.setText(String.valueOf(sekH));

                } catch (ParseException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Nespravny format vstupu");
                }

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    cas.setText(dateFormat.format(new Date()));

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
