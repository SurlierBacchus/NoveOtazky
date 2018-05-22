import com.tilgnerka.draw.DrawHelper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class O30 {
    public static void main(String[] args) {
        new O30();
    }

    private JLabel img1;
    private JLabel img2;
    private JButton kopiaButton;
    private JButton zrkadloButton;
    private JPanel mainPanel;

    private BufferedImage image;

    private O30() {
        DrawHelper.initializeDefaultFrame("Zrkadlo", 720, 480, mainPanel);

        kopiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    image = ImageIO.read(new File("maturita/30/obrazok.jpg"));
                    img1.setIcon(new ImageIcon(image));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        zrkadloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image == null) return;

                BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        copy.setRGB(image.getWidth() - i - 1, j, image.getRGB(i, j));
                    }
                }

                img2.setIcon(new ImageIcon(copy));
            }
        });
    }
}
