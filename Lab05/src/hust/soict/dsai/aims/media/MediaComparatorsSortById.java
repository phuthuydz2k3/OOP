package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorsSortById implements Comparator<Media>
{
    @Override
    public int compare(Media media1, Media media2)
    {
        int costComparion = Integer.compare(media1.getId(), media2.getId());

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
