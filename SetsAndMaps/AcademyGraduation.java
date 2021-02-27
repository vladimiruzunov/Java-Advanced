import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> studentsWithGrades = new TreeMap<>();
        while (n-- > 0){
            String name = scanner.nextLine();

            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToDouble(Double::parseDouble)
                    .toArray();
            studentsWithGrades.putIfAbsent(name,grades);
        }
        studentsWithGrades.forEach((k, v)->{
            System.out.printf("%s is graduated with %.3f%n", k,
                    Arrays.stream(v).average().orElse(0));
        });

    }
}
