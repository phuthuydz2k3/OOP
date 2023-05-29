package main;

import utilitiesClasses.Cart;
import utilitiesClasses.Store;
import utilitiesClasses.hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aims
{
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args)
    {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation"
                , "Roger Allers", 87, 19.95f);

        Track track = new Track("Haha", 3);
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track);

        CompactDisc cd = new CompactDisc(1, "Java Core I", "Coding", (float) 30.00, 2
                , "None", "Tran Anh", tracks);

        Book book = new Book(1, "C Programming", "Coding", (float) 20.00);
        book.addAuthor("Tran Anh");
        book.addAuthor("Do Hong Hai");
        book.addAuthor("Mai Duc An");

        store.addMedia(dvd);
        store.addMedia(cd);
        store.addMedia(book);

        runAIMS();
    }

    private static void runAIMS()
    {
        int place = 4;
        int option;

        showMenu();
        option = scannerOption(place);
        while (option < 0 || option >= place)
        {
            showMenu();
            option = scannerOption(place);
        }

        if (option == 1)
        {
            runStore();
        }
        else if (option == 2)
        {
            updateStore();
        }
        else if (option == 3)
        {
            runCartMenu();
        }
        else if (option == 0)
        {
            return;
        }
    }

    private static void runStore()
    {
        store.printMedia();

        int place = 5;
        int option;

        storeMenu();
        option = scannerOption(place);
        while (option < 0 || option >= place)
        {
            storeMenu();
            option = scannerOption(place);
        }

        if (option == 1)
        {
            showDetail();
            runStore();
        }
        else if (option == 2)
        {
            addAMediaToCart();
            runStore();
        }
        else if (option == 3)
        {
            playAMedia();
            runStore();
        }
        else if (option == 0)
        {
            runAIMS();
        }
    }

    private static void updateStore()
    {
        store.printMedia();
        System.out.print("1. Add a media to the store\n2. Remove a media from the store\n0. Back\nEnter 0-1-2: ");
        int place = 3;
        int option = scannerOption(place);
        while (option < 0 || option >= place)
        {
            System.out.println("Enter your option: ");
            option = scannerOption(place);
        }

        if (option == 1)
        {
            addMediaToStore();
        }
        else if (option == 2)
        {
            removeMedia();
            updateStore();
        }
        else if (option == 0)
        {
            runAIMS();
        }
    }

    private static void runCartMenu()
    {
        int place = 6;
        int option;

        cartMenu();
        option = scannerOption(place);
        while (option < 0 || option >= place)
        {
            cartMenu();
            option = scannerOption(place);
        }

        if (option == 1)
        {
            filterCartMedias();
        }
        else if (option == 2)
        {
            sortCartMedias();
        }
        else if (option == 3)
        {
            runAIMS();
        }
        else if (option == 4)
        {
            runAIMS();
        }
        else if (option == 5)
        {
            placeOrder();
        }
        else if (option == 0)
        {
            runAIMS();
        }
    }

    private static void filterCartMedias()
    {

    }

    private static void sortCartMedias()
    {

    }

    private static void placeOrder()
    {

    }

    private static void cartMenu()
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-1-2-3-4-5): ");
    }

    private static void addMediaToStore()
    {
        Scanner in = new Scanner(System.in);
        String title;

        System.out.print("Enter the title: ");
        title = in.nextLine().trim(); // Trim leading/trailing whitespaces

        while (title.isEmpty()) {
            System.out.print("Enter the title: ");
            title = in.nextLine().trim(); // Trim leading/trailing whitespaces
        }

        Media media = store.searchForMedia(title);

        if (media != null)
        {
            System.out.println("Already on the store!");
        }
        else
        {
            System.out.print("What dou want to add? 1. aBook 2. aDVD 3. CD 0. Back\nEnter 0-1-2-3: ");
            int option = scannerOption(4);

            System.out.print("Enter id: ");
            int id = in.nextInt();
            in.nextLine();
            System.out.print("Enter category: ");
            String category = in.nextLine();
            System.out.print("Enter float: ");
            float cost = in.nextFloat();
            Media newMedia = null;

            if (option != 0)
            {
                if (option == 1)
                {
                    newMedia = new Book(id, title, category, cost);
                }
                else if (option == 2)
                {
                    newMedia = new DigitalVideoDisc(title, category, "", 23, cost);
                }
                else if (option == 3)
                {
                    newMedia = new CompactDisc(id, title, category, cost, 2, "", "", null);
                }

                store.addMedia(newMedia);
                updateStore();
            }
            else if (option == 0)
            {
                updateStore();
            }
        }
    }
    private static void removeMedia()
    {
        Media media = store.searchForMedia();

        if (media != null)
        {
            store.removeMedia(media);
            System.out.println("Successfully removed");
        }
        else
        {
            System.out.println("Not on the store!");
        }
    }

    private static void showDetail()
    {
        Media media = store.searchForMedia();
        if (media != null)
        {
            System.out.println(media);
            String type = media.getClass().getSimpleName();
            int place;
            int option;

            if (type.equals("Book"))
            {
                place = 2;
            }
            else
            {
                place = 3;
            }

            mediaDetailsMenu(place);
            option = scannerOption(place);
            while (option < 0 || option >= place)
            {
                mediaDetailsMenu(place);
                option = scannerOption(place);
            }

            if (option == 0)
            {
                runStore();
            }
        }
        else
        {
            System.out.println("Not found");
        }
    }

    private static void addAMediaToCart()
    {
        store.printMedia();
        Media media = store.searchForMedia();

        if (media != null)
        {
            cart.addMedia(media);
        }
        else
        {
            System.out.println("Not found");
        }

    }

    private static void playAMedia()
    {
        Media media = store.searchForMedia();

        if (media != null)
        {
            String type = media.getClass().getSimpleName();
            if (type.equals("Book"))
            {
                System.out.println("Cant be played");
            }
            else
            {
                System.out.println("Playing");
            }
        }
        else
        {
            System.out.println("Not found");
        }
    }

    private static void showMenu()
    {
        System.out.println("AIMS: ");
        System.out.println("------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    private static void storeMenu()
    {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    private static void mediaDetailsMenu(int place)
    {
        if (place == 3)
        {
            System.out.println("Options: ");
            System.out.println("-------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
        }
        else if (place == 2)
        {
            System.out.println("Options: ");
            System.out.println("-------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1: ");
        }
    }

    private static int scannerOption(int max)
    {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        boolean validInput = false;

        while (!validInput)
        {
            if (scanner.hasNextInt())
            {
                option = scanner.nextInt();
                validInput = true;
            } else {
                System.out.print("Invalid input. Please enter an integer between 0 and " + (max - 1) + ": ");
                scanner.next();
            }
        }

        return option;
    }

    private static int scannerOption()
    {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        boolean validInput = false;

        while (!validInput)
        {
            if (scanner.hasNextInt())
            {
                option = scanner.nextInt();
                validInput = true;
            } else {
                System.out.print("Invalid input. Please enter an integer : ");
                scanner.next();
            }
        }

        return option;
    }
}
