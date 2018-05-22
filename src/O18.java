import java.util.Scanner;

public class O18 {
    public static void main(String[] args) {
        new O18();
    }

    private O18() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        for (int i = 0; i < input.length(); i++){
            System.out.println(input.substring(0, input.length() - i));
        }
    }
}
