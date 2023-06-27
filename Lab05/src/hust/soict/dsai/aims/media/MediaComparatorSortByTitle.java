package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorSortByTitle implements Comparator<Media>
{
    @Override
    public int compare(Media media1, Media media2)
    {
        int titleComparion = media1.getTitle().compareTo(media2.getTitle());

        if (titleComparion != 0)
        {
            return titleComparion;
        }
        else
        {
            return Float.compare(media2.getCost(), media1.getCost());
        }
    }
}
