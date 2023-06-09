import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number n: ");
        int n = in.nextInt();

        pattern(n, n);
    }

    static void printSpace(int space)
    {
        if (space == 0)
            return;
        System.out.print(" ");
 
        printSpace(space - 1);
    }
 
    static void printStar(int asterisk)
    {
        if (asterisk == 0)
            return;
        System.out.print("* ");
 
        printStar(asterisk - 1);
    }
 
    static void pattern(int n, int num)
    {
        if (n == 0)
            return;
        printSpace(n - 1);
        printStar(num - n + 1);
        System.out.println("");
 
        pattern(n - 1, num);
    }
}
