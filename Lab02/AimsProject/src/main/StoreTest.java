package main;

import test.DigitalVideoDisc;
import test.Store;

public class StoreTest
{
    public static void main(String[] args)
    {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation"
                , "Roger Allers", 87, 19.95f);
        Store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction"
                , "Geogre Lucas", 87, 24.95f);
        Store.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation"
                , "Roger Allers",18.99f);
        Store.addDVD(dvd3);

        System.out.println(Store.itemsInStore.length);

        Store.removeDVD(dvd3);

        System.out.println(Store.itemsInStore.length);
    }
}
