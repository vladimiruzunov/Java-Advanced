import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numsInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = numsInput[0];
        int s = numsInput[1];
        int x = numsInput[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <n ; i++) {
            int number = numbers[i];
            stack.push(number);
        }
        while (s > 0 && !stack.isEmpty()){
            stack.pop();
            s--;
        }
        if (!stack.isEmpty()){
            System.out.println(0);
        }
        if (stack.contains(x)){
            System.out.println("true");
        }else {
            Integer minElement = Collections.min(stack);
            System.out.println(minElement);
        }
    }
}
