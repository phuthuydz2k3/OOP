package utilitiesClasses;

import utilitiesClasses.hust.soict.dsai.aims.media.Media;
import java.util.*;

public class Store
{
    public static ArrayList<Media> itemsInStore = new ArrayList<>();
    public static void addMedia(Media newMedia)
    {
        if (!itemsInStore.contains(newMedia))
        {
            itemsInStore.add(newMedia);
        }
    }

    public static void removeMedia(Media media)
    {
        if (itemsInStore.contains(media))
        {
            itemsInStore.remove(media);
        }
    }
}
