import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class O17 {
    public static void main(String[] args) {
        new O17();
    }

    private O17(){
        Scanner scanner;
        PrintWriter printWriter;

        try {
            scanner = new Scanner(new File("maturita/17/zdroj.txt"));
            printWriter = new PrintWriter(new File("maturita/17/zrkadlo.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while (scanner.hasNextLine()){
            char[] line = scanner.nextLine().toCharArray();
            StringBuilder out = new StringBuilder();

            for (int i = line.length - 1; i >= 0; i--) {
                out.append(line[i]);
            }

            printWriter.println(out.toString());
        }

        scanner.close();
        printWriter.close();
    }
}
