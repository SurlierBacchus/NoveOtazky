import com.tilgnerka.draw.DrawHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

                LocalDateTime teraz = LocalDateTime.now();
                LocalDateTime narodenie;
                try{
                    narodenie = LocalDateTime.parse(datum + " " + cas, DateTimeFormatter.ofPattern("d.M.yyyy H:m:s"));
                } catch (DateTimeParseException ex){
                    JOptionPane.showMessageDialog(frame, "Nespravny vstup");
                    return;
                }
                LocalDateTime rozdiel;

                rozdiel = teraz.minusYears(narodenie.getYear());
                rozdiel = rozdiel.minusMonths(narodenie.getMonthValue());
                rozdiel = rozdiel.minusDays(narodenie.getDayOfMonth());
                rozdiel = rozdiel.minusHours(narodenie.getHour());
                rozdiel = rozdiel.minusMinutes(narodenie.getMinute());
                rozdiel = rozdiel.minusSeconds(narodenie.getSecond());

                rok.setText(String.valueOf(rozdiel.getYear()));
                mesiac.setText(String.valueOf(rozdiel.getMonthValue()));
                int tyzdenH = rozdiel.getDayOfMonth() / 7;
                int denH = rozdiel.getDayOfMonth() % 7;
                tyzden.setText(String.valueOf(tyzdenH));
                den.setText(String.valueOf(denH));
                hodina.setText(String.valueOf(rozdiel.getHour()));
                minuta.setText(String.valueOf(rozdiel.getMinute()));
                sekunda.setText(String.valueOf(rozdiel.getSecond()));
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    cas.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.M.yyyy HH:mm:ss")));

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }).start();
    }
}
