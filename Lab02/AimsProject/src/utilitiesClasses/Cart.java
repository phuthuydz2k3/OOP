package utilitiesClasses;

import utilitiesClasses.hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cart
{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered;
    private int qtyOrdered;

    public Cart()
    {
        itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }


    public void addDigitalVideoDics(DigitalVideoDisc disc)
    {
        if (qtyOrdered <= MAX_NUMBERS_ORDERED)
        {
            itemsOrdered[qtyOrdered++] = disc;
        }
    }

    public void addDigitalVideoDics(DigitalVideoDisc[] discs)
    {
        for (DigitalVideoDisc disc : discs)
        {
            if (qtyOrdered <= MAX_NUMBERS_ORDERED)
            {
                itemsOrdered[qtyOrdered++] = disc;
            }
        }
    }

    public void addDigitalVideoDics(DigitalVideoDisc disc1, DigitalVideoDisc disc2)
    {
        if (qtyOrdered <= MAX_NUMBERS_ORDERED)
        {
            itemsOrdered[qtyOrdered++] = disc1;
        }

        if (qtyOrdered <= MAX_NUMBERS_ORDERED)
        {
            itemsOrdered[qtyOrdered++] = disc2;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        ArrayList<DigitalVideoDisc> arrls = new ArrayList<>(qtyOrdered);
        Collections.addAll(arrls, itemsOrdered);
        arrls.remove(disc);
        itemsOrdered = arrls.toArray(new DigitalVideoDisc[--qtyOrdered]);
    }

    public float totalCost()
    {
        float total = (float) 0.0;

        for (int i = 0; i < qtyOrdered; i++)
        {
            total += itemsOrdered[i].getCost();
        }

        return total;
    }

    public void printOrders()
    {
        for (int i = 0; i < qtyOrdered; i++)
        {
            System.out.println(itemsOrdered[i].getId() + ". DVD - " + itemsOrdered[i].getTitle() + " - "
                    + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
                    + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: " + totalCost());
    }

    public void searchByID()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter id of the DVD you want: ");
        int id = in.nextInt();

        int i = 0;
        while (i < qtyOrdered)
        {
            if (itemsOrdered[i].getId() == id)
            {
                System.out.println(itemsOrdered[i].getId() + ". DVD - " + itemsOrdered[i].getTitle() + " - "
                        + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
                        + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost());
                break;
            }

            i++;
        }

        if (i == qtyOrdered)
        {
            System.out.println("not found");
        }
    }

    public void searchByTitle()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter title of the DVD you want: ");
        String title = in.nextLine();

        int i = 0;
        while (i < qtyOrdered)
        {
            if (itemsOrdered[i].getTitle().equals(title))
            {
                System.out.println(itemsOrdered[i].getId() + ". DVD - " + itemsOrdered[i].getTitle() + " - "
                        + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - "
                        + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost());
                break;
            }

            i++;
        }

        if (i == qtyOrdered)
        {
            System.out.println("not found");
        }
    }
}
