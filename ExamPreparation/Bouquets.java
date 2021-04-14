import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(tulipsStack::push);
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodilsQueue::offer);
        int bouquetCount = 0;
        int storedSum = 0;
        while (!(tulipsStack.isEmpty() || daffodilsQueue.isEmpty())){
            int sum = tulipsStack.peek() + daffodilsQueue.peek();
            if (sum == 15){
                tulipsStack.pop();
                daffodilsQueue.poll();
                bouquetCount++;
            }else if (sum > 15){
                int lowered = tulipsStack.pop() - 2;
                tulipsStack.push(lowered);
            }else {
                storedSum += tulipsStack.pop() + daffodilsQueue.poll();
            }
            while (storedSum >= 15){
                bouquetCount++;
                storedSum -= 15;
            }
        }
        if (bouquetCount >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquetCount);
        }else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetCount);
        }
    }
}