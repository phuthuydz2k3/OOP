package main;

import utilitiesClasses.hust.soict.dsai.aims.media.Book;
import utilitiesClasses.hust.soict.dsai.aims.media.CompactDisc;
import utilitiesClasses.hust.soict.dsai.aims.media.DigitalVideoDisc;
import utilitiesClasses.hust.soict.dsai.aims.media.Media;
import utilitiesClasses.hust.soict.dsai.aims.media.Track;
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

        CompactDisc cd = new CompactDisc(1, "Java Core I", "Coding", (float) 30.00, 2
                , "None", "Tran Anh", tracks);

        Book book = new Book(1, "C Programming", "Coding", (float) 20.00);
        book.addAuthor("Tran Anh");
        book.addAuthor("Do Hong Hai");
        book.addAuthor("Mai Duc An");

        medias.add(dvd);
        medias.add(cd);
        medias.add(book);

        for (Media media : medias)
        {
            System.out.println(media.toString());
        }
    }
}
