import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] singleRow = scanner.nextLine().split("");
            for (int j = 0; j < singleRow.length; j++) {
                matrix[i][j] = singleRow[j];
            }
        }

        int pollinatedFlowers = 0;
        String command = scanner.nextLine();
        boolean beeIsOut = false;
        while (!command.equals("End")) {
            int row = findCurrentBeeRow(matrix);
            int col = findCurrentBeetCol(matrix);

            switch (command) {
                case "up":
                    if (row == 0) {
                        beeIsOut = true;

                    } else {
                        if (matrix[row - 1][col].equals("f")) {
                            matrix[row - 1][col] = "B";
                            pollinatedFlowers++;

                        } else if (matrix[row - 1][col].equals("O")) {
                            if (matrix[row - 2][col].equals("f")) {
                                pollinatedFlowers++;
                            }
                            matrix[row - 2][col] = "B";
                            matrix[row - 1][col] = ".";

                        } else if (matrix[row - 1][col].equals(".")) {
                            matrix[row - 1][col] = "B";
                        }
                    }

                    break;
                case "down":
                    if (row == matrix.length - 1) {
                        beeIsOut = true;

                    } else {
                        if (matrix[row + 1][col].equals("f")) {
                            matrix[row + 1][col] = "B";
                            pollinatedFlowers++;

                        } else if (matrix[row + 1][col].equals("O")) {
                            if (matrix[row + 2][col].equals("f")) {
                                pollinatedFlowers++;
                            }
                            matrix[row + 2][col] = "B";
                            matrix[row + 1][col] = ".";

                        } else if (matrix[row + 1][col].equals(".")) {
                            matrix[row + 1][col] = "B";
                        }
                    }

                    break;
                case "left":
                    if (col == 0) {
                        beeIsOut = true;

                    } else {
                        if (matrix[row][col - 1].equals("f")) {
                            matrix[row][col - 1] = "B";
                            pollinatedFlowers++;

                        } else if (matrix[row][col - 1].equals("O")) {
                            if (matrix[row][col - 2].equals("f")) {
                                pollinatedFlowers++;
                            }
                            matrix[row][col - 2] = "B";
                            matrix[row][col - 1] = ".";

                        } else if (matrix[row][col - 1].equals(".")) {
                            matrix[row][col - 1] = "B";
                        }
                    }

                    break;
                case "right":
                    if (col == matrix[0].length - 1) {
                        beeIsOut = true;

                    } else {
                        if (matrix[row][col + 1].equals("f")) {
                            matrix[row][col + 1] = "B";
                            pollinatedFlowers++;

                        } else if (matrix[row][col + 1].equals("O")) {
                            if (matrix[row][col + 2].equals("f")) {
                                pollinatedFlowers++;
                            }
                            matrix[row][col + 2] = "B";
                            matrix[row][col + 1] = ".";

                        } else if (matrix[row][col + 1].equals(".")) {
                            matrix[row][col + 1] = "B";
                        }
                    }
                    break;
            }

            matrix[row][col] = ".";
            if (beeIsOut) {
                System.out.println("The bee got lost!");
                break;
            }
            command = scanner.nextLine();
        }

        if (pollinatedFlowers < 5) {
            int needed = 5 - pollinatedFlowers;
            System.out.println("The bee couldn't pollinate the flowers, she needed " + needed + " flowers more");

        } else {
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");

        }

        for (String[] rows : matrix) {
            for (String cols : rows) {
                System.out.print(cols);
            }
            System.out.println();
        }

    }

    private static int findCurrentBeetCol(String[][] matrix) {
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("B")) {
                    col = j;
                    break;
                }
            }
        }

        return col;
    }

    private static int findCurrentBeeRow(String[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("B")) {
                    row = i;
                    break;
                }
            }
        }

        return row;
    }
}