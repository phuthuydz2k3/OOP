package main;

import utilitiesClasses.hust.soict.dsai.aims.media.Book;
import utilitiesClasses.hust.soict.dsai.aims.media.CompactDisc;
import utilitiesClasses.hust.soict.dsai.aims.media.DigitalVideoDisc;
import utilitiesClasses.hust.soict.dsai.aims.media.Media;
import utilitiesClasses.hust.soict.dsai.aims.media.Track;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class PolymorphismToString
{
    public static void main(String[] args)
    {
        List<Media> medias = new ArrayList<>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation"
                , "Roger Allers", 87, 19.95f);

        Track track = new Track("Haha", 3);
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track);

        CompactDisc cd = new CompactDisc("Java Core I", "Coding", (float) 30.00, 2
                , "None", "Tran Anh", tracks);

        Book book = new Book("C Programming", "Coding", (float) 20.00);
        book.addAuthor("Tran Anh");
        book.addAuthor("Do Hong Hai");
        book.addAuthor("Mai Duc An");

        medias.add(dvd);
        medias.add(cd);
        medias.add(book);

        System.out.println("Print the list: ");
        for (Media media : medias)
        {
            System.out.println(media.toString());
        }

        System.out.println("Print the list by library order");
        Collections.sort(medias, Media.COMPARE_BY_TITLE_COST);
        for (Media media : medias)
        {
            System.out.println(media.toString());
        }

        System.out.println("Print the list by cost order");
        Collections.sort(medias, Media.COMPARE_BY_COST_TITLE);
        for (Media media : medias)
        {
            System.out.println(media.toString());
        }
    }
}
