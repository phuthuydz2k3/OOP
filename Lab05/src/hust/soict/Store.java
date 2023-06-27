package hust.soict;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class Store
{
    private final ArrayList<Media> itemsInStore;
    private static int ID = 1;

    public Store()
    {
        itemsInStore = new ArrayList<>();
    }
    public void addMedia(Media newMedia)
    {
        if (!itemsInStore.contains(newMedia))
        {
            newMedia.setId(ID++);
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
        System.out.println("hust.soict.Store:\n");
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

    public Media searchMediaById(int id)
    {
        for (Media media : itemsInStore)
        {
            if (id == media.getId())
            {
                return media;
            }
        }

        return null;
    }

    public void setMediasId()
    {
        for (Media media : itemsInStore)
        {
            if (media.getId() == 0)
            {
                media.setId(itemsInStore.indexOf(media) + 1);
            }
        }
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
