package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());
        LystyIterator lystyIterator = new LystyIterator(data);

        String line = "";
        while (!"END".equals(line = scanner.nextLine())) {
            switch (line) {
                case "HasNext":
                    System.out.println(lystyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(lystyIterator.move());
                    break;
                case "Print":
                    try {
                        lystyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());

                    }

                    break;
            }
        }

    }
}
