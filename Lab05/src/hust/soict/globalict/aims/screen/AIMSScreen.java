package hust.soict.globalict.aims.screen;

import hust.soict.Cart;
import hust.soict.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;

import java.util.ArrayList;

public class AIMSScreen
{
    public static void main(String[] args)
    {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King1", "Animation"
                , "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King2", "Animation"
                , "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King3", "Animation"
                , "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King4", "Animation"
                , "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King5", "Animation"
                , "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lion King6", "Animation"
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

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(cd);
        store.addMedia(book);
        store.setMediasId();

        new StoreScreen(store, cart);
    }
}
