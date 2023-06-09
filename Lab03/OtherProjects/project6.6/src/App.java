import java.util.Arrays;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) 
    {
        int[][] matrixA;
        int[][] matrixB;
        int[][] matrixC;
        int row, col;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        row = in.nextInt();
        System.out.print("Enter number of columns: ");
        col = in.nextInt();
        matrixA = new int[row][col];
        matrixB = new int[row][col];
        matrixC = new int[row][col];

        System.out.println("Enter matrixA");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matrixA[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter matrixB");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matrixB[i][j] = in.nextInt();
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        System.out.println("Sum of the two matrices:");
        for (int i = 0; i < row; i++)
        {
            System.out.println(Arrays.toString(matrixC[i]));
        }
    }
}
