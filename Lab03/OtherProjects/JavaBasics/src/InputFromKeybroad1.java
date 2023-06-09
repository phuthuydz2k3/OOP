import java.util.Scanner;

public class InputFromKeybroad1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("What's your name? ");
        String name = in.nextLine();
        System.out.print("How old are you? ");
        int age = in.nextInt();
        System.out.print("How tall are you (m)? ");
        double height = in.nextDouble();

        System.out.println("Mr/Mrs " + name + ", " + age + " years old. Your height is " + height + ".");
    }
}
