import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class O23 {
    public static void main(String[] args) {
        new O23();
    }

    private O23() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("maturita/23/zdroj.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String konceViet = ".!?";
        int pocet = 0;

        while (scanner.hasNextLine()){
            char[] input = scanner.nextLine().toCharArray();

            for (int i = 1; i < input.length; i++){
                if (konceViet.contains(String.valueOf(input[i]))) {
                    if (!konceViet.contains(String.valueOf(input[i-1]))){
                        pocet++;
                    }
                }
            }
        }
        scanner.close();

        System.out.println(String.format("V dokumente sa nachadza %d viet", pocet));
    }
}
