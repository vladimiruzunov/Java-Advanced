import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], Integer> getMinElement = numbers -> Arrays.stream(numbers)
                .min().getAsInt();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int result = getMinElement.apply(numbers);
        System.out.println(result);
    }
}
