import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueNames = new LinkedHashSet<>();

        int namesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <namesCount ; i++) {
            String name = scanner.nextLine();
            uniqueNames.add(name);
        }
        uniqueNames.forEach(System.out::println);
    }
}
