import com.tilgnerka.draw.DrawHelper;
import com.tilgnerka.draw.shapes.Rectangle;

import java.awt.*;

public class O26 {
    public static void main(String[] args) {
        new O26();
    }

    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;
    public static final int VYSKA = 10;

    private O26() {
        DrawHelper drawHelper = new DrawHelper("Pyramida", 720, 480);

        for (int i = 0; i <= VYSKA; i++) {
            for (int j = 0; j < 2*VYSKA - 2*i - 1; j++) {
                drawHelper.draw(new Rectangle(
                        150 + i*WIDTH + j*WIDTH,
                        300 - i*HEIGHT,
                        WIDTH, HEIGHT,
                        Color.YELLOW, true
                ));
                drawHelper.draw(new Rectangle(
                        150 + i*WIDTH + j*WIDTH,
                        300 - i*HEIGHT,
                        WIDTH, HEIGHT,
                        Color.BLACK, false
                ));
            }
        }
    }
}
