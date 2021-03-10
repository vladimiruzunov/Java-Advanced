import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static Predicate<String> startWithUppercase
            = str -> str != null && !str.isEmpty()
            &&
            Character.isUpperCase(str.charAt(0));
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startWithUppercase)
                .collect(Collectors.toList());
        System.out.println(uppercaseWords.size());
        System.out.println(uppercaseWords.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
