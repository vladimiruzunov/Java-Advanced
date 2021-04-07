import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(deque::offer);


        int wreaths = 0;
        int sum = 0;
        int leftFlowers = 0;
        while (!(deque.isEmpty() || stack.isEmpty())){
            sum = deque.peek() + stack.peek();
            if (sum == 15){
                deque.poll();
                stack.pop();
                wreaths++;
            }else if (sum < 15){
                deque.poll();
                stack.pop();
                leftFlowers += sum;
                if (leftFlowers >= 15){
                    wreaths++;
                    leftFlowers -= 15;
                }
            }else {
                int decreased = stack.pop() - 2;
                stack.push(decreased);
            }
        }
        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
