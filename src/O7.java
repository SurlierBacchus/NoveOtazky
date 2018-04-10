import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class O7 {
    public static void main(String[] args) {
        new O7();
    }

    private O7(){
        int samohlasky = 0, spoluhlasky = 0, interpunkcne = 0;

        try {
            Scanner scanner = new Scanner(new FileReader("maturita/7/vstup.txt"));

            while (scanner.hasNext()){
                String s = scanner.next();

                for (char c : s.toCharArray()){
                    if (Character.isLetter(c)){
                        if ("AaEeIiOoUuYy".contains(String.valueOf(c))){
                            samohlasky++;
                        } else {
                            spoluhlasky++;
                        }
                    }
                    else if (c != ' '){
                        interpunkcne++;
                    }

                }
                System.out.println(s);
            }

            System.out.println("Samohlasky: " + samohlasky);
            System.out.println("Spoluhlasky: " + spoluhlasky);
            System.out.println("Interpunkcne: " + interpunkcne);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
