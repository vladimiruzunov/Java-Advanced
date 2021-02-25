import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner, ", ");
        int sum = 0;
        for (int[] arr : matrix) {
            for (int number : arr) {
                sum+=number;
            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }
    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine()
                .split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private static int[][] readMatrix(Scanner scanner, String pattern){
        int[] rowsAndCold = readArray(scanner,pattern);

        int row = rowsAndCold[0];
        int col = rowsAndCold[1];
        int[][] matrix = new int[row][col];
        for (int i = 0; i <row ; i++) {
            matrix[i]=readArray(scanner,pattern);
        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            int[] arr = matrix[i];
            for (int j = 0; j <arr.length ; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}
