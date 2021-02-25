import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }
        int[] indexes = readArray(scanner, "\\s+");
        int wrongValue = matrix[indexes[0]][indexes[1]];
        ArrayList<int[]> fixInfo = new ArrayList<>();
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                if (matrix[row][col] == wrongValue){
                    int rightValue = calculateRightValue(matrix, row, col, wrongValue);
                fixInfo.add(new int[]{row, col, rightValue});

                }
            }
        }
        for (int[] info : fixInfo) {
            matrix[info[0]][info[1]] = info[2];
        }
        printMatrix(matrix);
    }

    private static int calculateRightValue(int[][] matrix, int row, int col, int wrongValue) {
        int rightValue = 0;
        if (isInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue){
            rightValue += matrix[row - 1][col];
        }
        if (isInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue){
            rightValue += matrix[row + 1][col];
        }if (isInBounds(matrix, row , col - 1) && matrix[row][col - 1] != wrongValue){
            rightValue += matrix[row][col-1];
        }if (isInBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue){
            rightValue += matrix[row][col+1];
        }

        return rightValue;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row < matrix.length  && row >= 0 && col < matrix[row].length && col >=0;
    }
    private static boolean isOutOfBounds(int[][] matrix, int row, int col) {
        return !isInBounds(matrix, row, col);
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine()
                .split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
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
