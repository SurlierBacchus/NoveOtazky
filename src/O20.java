import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Robert Gers on 19.04.2018.
 */
public class O20 {
    public static void main(String[] args) {
        new O20();
    }

    private O20() {
        try {
            Scanner scanner = new Scanner(new FileReader(new File("maturita/20/meteo.txt")));
            List<Integer> input = new ArrayList<>();

            while (scanner.hasNextInt()){
                input.add(scanner.nextInt());
            }
            scanner.close();

            float c = 0;
            for (Integer i : input){
                c += i;
            }
            c /= (float) input.size();

            float f = 9f/5f * c + 32f;

            System.out.println("Priemerna teplota: " + c + "°C, " + f + "°F");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
