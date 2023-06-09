import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulate
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] a;
        int size, sum = 0;
        double average;

        System.out.print("Enter number of elements: ");
        size = in.nextInt();
        a = new int[size];
        
        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++)
        {
            a[i] = in.nextInt();
            sum += a[i];
        }
        average = sum / size;

        System.out.println("Before sorted: " + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("After sorted: " + Arrays.toString(a));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
