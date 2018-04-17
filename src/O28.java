import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class O28 {
    public static void main(String[] args) {
        new O28();
    }

    private O28() {
        try {
            Scanner scanner = new Scanner(new FileReader(new File("maturita/28/vstup.txt")));
            String input = scanner.nextLine();
            scanner.close();

            int vysledok = 0;
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < input.length(); i++){
                if (Character.isDigit(input.charAt(i))){
                    temp.append(input.charAt(i));
                }
                else if (input.charAt(i) == '-'){
                    if (temp.length() == 0) {
                        temp.append(input.charAt(i));
                    } else {
                        vysledok += Integer.parseInt(temp.toString());
                        temp = new StringBuilder("-");
                    }
                }
                else {
                    vysledok += Integer.parseInt(temp.toString());
                    temp = new StringBuilder();
                }
            }

            System.out.println(vysledok);

            PrintWriter out = new PrintWriter("maturita/28/vystup.txt");
            out.println(vysledok);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
