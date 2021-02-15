import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfOperation = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> memorySTack = new ArrayDeque<>();
        for (int i = 0; i < numbersOfOperation; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String argument = "";
            if (tokens.length > 1){
                argument = tokens[1];
            }
            switch (tokens[0]){
                case "1":
                    memorySTack.push(text.toString());
                text.append(argument);

                    break;
                case "2":
                    memorySTack.push(text.toString());
                    int count = Integer.parseInt(argument);
                    for (int j = 0; j < count; j++) {
                        text = new StringBuilder(text.substring(0, text.length()-1));
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(argument);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                if (!memorySTack.isEmpty()){
                    text = new StringBuilder(memorySTack.pop());
                }
                    break;
            }
        }
    }
}
