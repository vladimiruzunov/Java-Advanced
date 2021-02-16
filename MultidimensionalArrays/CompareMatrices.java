import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;
        if (!areNotEqual){
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];
                areNotEqual = firstArr.length != secondArr.length;
                if (!areNotEqual){
                    for (int col = 0; col <firstArr.length ; col++) {
                        if (firstArr[col] != secondArr[col]){
                            areNotEqual = true;
                            break;
                        }
                    }
                }
                if (areNotEqual){
                    break;
                }
            }
        }

        String output = areNotEqual ? "not equal" :  "equal";
        System.out.println(output);

    }
    private static int[][] readMatrix(Scanner scanner){
        int[] rowsAndCold = readArray(scanner);

        int row = rowsAndCold[0];
        int col = rowsAndCold[1];
        int[][] matrix = new int[row][col];
        for (int i = 0; i <row ; i++) {
            matrix[i]=readArray(scanner);
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

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
