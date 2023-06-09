package main;

import utilitiesClasses.*;
import utilitiesClasses.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest
{
    public static void main(String[] args)
    {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation"
                , "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction"
                , "Geogre Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation"
                , "Roger Allers",18.99f);
        anOrder.addMedia(dvd3);
    }
}
