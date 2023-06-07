package utilitiesClasses;

import utilitiesClasses.hust.soict.dsai.aims.media.Media;
import java.util.*;

public class Store
{
    private final ArrayList<Media> itemsInStore;

    public Store()
    {
        itemsInStore = new ArrayList<>();
    }
    public void addMedia(Media newMedia)
    {
        if (!itemsInStore.contains(newMedia))
        {
            itemsInStore.add(newMedia);
        }
    }

    public void removeMedia(Media media)
    {
        if (itemsInStore.contains(media))
        {
            itemsInStore.remove(media);
        }
    }

    public void printMedia()
    {
        System.out.println("Store:\n");
        for (Media media : itemsInStore)
        {
            System.out.println(media.toString());
        }
        System.out.println();
    }

    public Media searchForMedia()
    {
        Scanner in = new Scanner(System.in);
        String title;

        System.out.print("Enter the title: ");
        title = in.nextLine();
        while (!isValidString(title))
        {
            System.out.print("Enter the title: ");
            title = in.nextLine();
        }

        for (Media media : itemsInStore)
        {
            if (title.equals(media.getTitle()))
            {
                return media;
            }
        }

        return null;
    }

    public Media searchForMedia(String title)
    {
        for (Media media : itemsInStore)
        {
            if (title.equals(media.getTitle()))
            {
                return media;
            }
        }

        return null;
    }

    private boolean isValidString(String inputLine)
    {
        return inputLine != null && !inputLine.isEmpty();
    }

    public ArrayList<Media> getItemsInStore()
    {
        return itemsInStore;
    }
}
