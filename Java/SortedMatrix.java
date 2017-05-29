import java.util.Scanner;

public class SortedMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row size: ");
        int row = sc.nextInt();
        System.out.print("Enter column size: ");
        int column = sc.nextInt();
        int[][] matrix = new int[row][column];
        System.out.println("Enter all the elements:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter element you want to find: ");
        int n = sc.nextInt();
        System.out.println(findIt(matrix, n) ? "Yeah!" : "Not found");
        System.out.println("Total negative numbers are: " + countNegatives(matrix));
    }

    private static int countNegatives(int[][] matrix) {
        int count = 0, i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0)
            if (matrix[i][j] < 0) {
                count += (j + 1);
                i++;
            } else
                j--;
        return count;
    }

    private static boolean findIt(int[][] matrix, int n) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0)
            if (matrix[i][j] == n) {
                System.out.print("Is your number at row " + ++i + " & column " + ++j + "? ");
                return true;
            } else if (matrix[i][j] > n)
                j--;
            else
                i++;
        return false;
    }
}