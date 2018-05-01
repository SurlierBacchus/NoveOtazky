import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class O1 {
    public static void main(String[] args) {
        new O1();
    }

    private O1(){
        String vstup;

        try {
            Scanner scanner = new Scanner(new FileReader(new File("maturita/1/vstup.txt")));
            vstup = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String vystup = "";
        for (int i = 0; i < vstup.length(); i++){
            vystup += vstup.charAt(i);
            if ("aeiouy".contains(String.valueOf(vstup.charAt(i)).toLowerCase())){
                vystup += "p" + vstup.charAt(i);
            }
        }

        System.out.println(vystup);
    }
}
