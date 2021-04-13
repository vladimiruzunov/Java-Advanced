import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(deque::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);
        int sum = 0;
        int claimedItems = 0;
        while (!(deque.isEmpty() || stack.isEmpty())){
            sum = deque.peek() + stack.peek();
            if (sum % 2 == 0){
                claimedItems += sum;
                deque.poll();
                stack.pop();
            }else {
                deque.offer(stack.pop());
            }
        }
        if (deque.isEmpty()){
            System.out.println("First magic box is empty.");
        }else {
            System.out.println("Second magic box is empty.");
        }
        if (claimedItems >= 90) {

            System.out.printf("Wow, your prey was epic! Value: %d",claimedItems);
        }else {
            System.out.printf("Poor prey... Value: %d",claimedItems);
        }

    }
}
