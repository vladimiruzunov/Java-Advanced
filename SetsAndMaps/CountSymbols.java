import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> charOccurances = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!charOccurances.containsKey(symbol)) {
                charOccurances.put(symbol, 1);
            } else {
                charOccurances.put(symbol, charOccurances.get(symbol) + 1);
            }

        }
        for (Map.Entry<Character, Integer> entry : charOccurances.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            System.out.printf("%c: %d time/s%n",key,value);
        }
    }
}
