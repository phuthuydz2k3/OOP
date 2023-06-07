package utilitiesClasses;

import utilitiesClasses.hust.soict.dsai.aims.media.DigitalVideoDisc;
import utilitiesClasses.hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cart
{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered;
    public Cart()
    {
        itemsOrdered = new ArrayList<>(MAX_NUMBERS_ORDERED);
    }

    public void addMedia(Media newMedia)
    {
        if (!itemsOrdered.contains(newMedia))
        {
            itemsOrdered.add(newMedia);
        }

        printCart();
    }

    public void removeMedia(Media media)
    {
        if (itemsOrdered.contains(media))
        {
            itemsOrdered.remove(media);
        }

        printCart();
    }

    public float totalCost()
    {
        float total = (float) 0.0;

        for (Media item : itemsOrdered)
        {
            total += item.getCost();
        }

        return total;
    }

    public void printCart()
    {
        System.out.println("Cart:\n");
        for (Media item : itemsOrdered)
        {
            System.out.println(item);
        }
    }

    public ArrayList<Media> getItemsOrdered()
    {
        return this.itemsOrdered;
    }

    public void setItemsOrderedEmpty()
    {
        this.itemsOrdered = new ArrayList<Media>();
    }
}
