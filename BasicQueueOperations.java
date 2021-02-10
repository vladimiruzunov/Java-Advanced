import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLineInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = firstLineInput[0];
        int s = firstLineInput[1];
        int x = firstLineInput[2];

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n ; i++) {
             int num = numbers[i];
             numbersQueue.offer(num);
        }
        for (int i = 0; i < s; i++) {
            if (!numbersQueue.isEmpty()){
                numbersQueue.poll();
            }
        }
        if (numbersQueue.isEmpty()){
            System.out.println("0");
        }else if (numbersQueue.contains(x)){
            System.out.println("true");
        }else {
            System.out.println(Collections.min(numbersQueue));
        }
    }
}
