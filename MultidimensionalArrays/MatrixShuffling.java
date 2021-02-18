import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = tokens[0];
        int m = tokens[1];

        int[][] matrix = new int[n][m];
        for (int row = 0; row <matrix.length ; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt). toArray();
        }
        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] data = input.split("\\s+");
            if (data[0].equals("swap")) {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                swapElements(row1, col1, row2, col2, matrix);
                input = scanner.nextLine();
            }
        }

    }

    private static void swapElements(int row1, int col1, int row2, int col2,int[][] matrix) {
        if (isValid(row1,col1, matrix) && isValid(row2, col2, matrix)){
            int tempElement = matrix[row1][col1];

            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2]= tempElement;
            printMatrix(matrix);
        }else {
            System.out.println("Invalid input!");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.print(String.format("%d ", ints));
        }
        System.out.println();
    }

    private static boolean isValid(int row, int col, int[][] matrix) {
        boolean isRowValid = row >= 0 && row < matrix.length;
        if (isRowValid && col >=0 && col < matrix[row].length){
            return true;
        }
        return false;
    }
}
