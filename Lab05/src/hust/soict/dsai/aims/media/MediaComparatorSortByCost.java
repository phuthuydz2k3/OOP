package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorSortByCost implements Comparator<Media>
{
    @Override
    public int compare(Media media1, Media media2)
    {
        int costComparion = Float.compare(media2.getCost(), media1.getCost());

        if (costComparion != 0)
        {
            return costComparion;
        }
        else
        {
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }
}
