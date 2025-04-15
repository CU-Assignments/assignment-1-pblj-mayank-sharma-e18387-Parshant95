import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows and columns for Matrix 1: ");
        int r1 = scanner.nextInt(), c1 = scanner.nextInt();

        System.out.print("Enter rows and columns for Matrix 2: ");
        int r2 = scanner.nextInt(), c2 = scanner.nextInt();

        int[][] matrix1 = new int[r1][c1];
        int[][] matrix2 = new int[r2][c2];

        System.out.println("Enter elements of Matrix 1:");
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c1; j++)
                matrix1[i][j] = scanner.nextInt();

        System.out.println("Enter elements of Matrix 2:");
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++)
                matrix2[i][j] = scanner.nextInt();

        if (r1 == r2 && c1 == c2) {
            System.out.println("Addition:");
            printMatrix(add(matrix1, matrix2));
        } else {
            System.out.println("Addition not possible: Dimensions mismatch.");
        }

        if (r1 == r2 && c1 == c2) {
            System.out.println("Subtraction:");
            printMatrix(subtract(matrix1, matrix2));
        } else {
            System.out.println("Subtraction not possible: Dimensions mismatch.");
        }

        if (c1 == r2) {
            System.out.println("Multiplication:");
            printMatrix(multiply(matrix1, matrix2));
        } else {
            System.out.println("Multiplication not possible: Incompatible dimensions.");
        }

        scanner.close();
    }

    public static int[][] add(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    public static int[][] subtract(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int r1 = a.length, c1 = a[0].length, c2 = b[0].length;
        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
