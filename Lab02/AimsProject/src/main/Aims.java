package main;

import utilitiesClasses.Store;

import java.util.Scanner;

public class Aims
{
    private static Store store = new Store();

    public static void main(String[] args)
    {

    }

    public static void runAIMS()
    {
        Scanner in = new Scanner(System.in);
        int option;
        int place = 4;

        showMenu();
        option = in.nextInt();
        while (option < 0 || option >= place)
        {
            showMenu();
            option = in.nextInt();
        }

        if (option == 1)
        {
            runStore();
        }
        else if (option == 0)
        {
            return;
        }
    }

    public static void runStore()
    {
        Scanner in = new Scanner(System.in);
        int option;
        int place = 5;

        storeMenu();
        option = in.nextInt();
        while (option < 0 || option >= place)
        {
            storeMenu();
            option = in.nextInt();
        }

        if (option == 1)
        {
            runCart();
        }
        else if (option == 0)
        {
            runAIMS();
        }
    }

    public static void runCart()
    {
        Scanner in = new Scanner(System.in);
        int option;
        int place = 3;

        mediaDetailsMenu();
        option = in.nextInt();
        while (option < 0 || option >= place)
        {
            mediaDetailsMenu();
            option = in.nextInt();
        }

        if (option == 1)
        {
            runCart();
        }
        else if (option == 0)
        {
            runStore();
        }
    }

    public static void showMenu()
    {
        System.out.println("AIMS: ");
        System.out.println("------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu()
    {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu()
    {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
}
