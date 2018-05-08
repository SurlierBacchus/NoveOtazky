import java.util.*;

public class O8 {
    public static void main(String[] args) {
        new O8();
    }

    private O8(){
        Scanner scanner = new Scanner(System.in);

        String[] in = scanner.nextLine().split(" ");
        List<Integer> cisla = new ArrayList<>(in.length);

        for (String s : in){
            try {
                Integer i = Integer.parseInt(s);
                cisla.add(i);
            } catch (NumberFormatException e) {
                System.out.println("Neplatny vstup");
                return;
            }
        }

        for (int j = 0; j < cisla.size(); j++) {
            for (int i = 0; i < cisla.size() - 1 - j; i++) {
                if (cisla.get(i) > cisla.get(i + 1)) {
                    cisla.set(i, cisla.set(i + 1, cisla.get(i)));
                }
            }
        }

        System.out.println(cisla.toString());
    }
}
