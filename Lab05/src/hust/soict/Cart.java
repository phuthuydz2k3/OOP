package hust.soict;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart
{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered;
    private static int ID = 1;
    public Cart()
    {
        itemsOrdered = new ArrayList<>(MAX_NUMBERS_ORDERED);
    }

    public void addMedia(Media newMedia)
    {
        if (!itemsOrdered.contains(newMedia))
        {
            newMedia.setId(ID++);
            itemsOrdered.add(newMedia);
        }
    }

    public void removeMedia(Media media)
    {
        if (itemsOrdered.contains(media))
        {
            itemsOrdered.remove(media);
        }
        for (Media theMedia : itemsOrdered)
        {
            theMedia.setId(itemsOrdered.indexOf(media) + 1);
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
        System.out.println("hust.soict.Cart:\n");
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
