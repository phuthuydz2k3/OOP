package utilitiesClasses;

import utilitiesClasses.hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.*;

public class Store
{
    public static DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
    public static int nbInStore = 0;
    public static void addDVD(DigitalVideoDisc dvd)
    {
        itemsInStore[nbInStore++]  = dvd;
    }

    public static void removeDVD(DigitalVideoDisc dvd)
    {
        List al = Arrays.asList(itemsInStore);
        ArrayList<DigitalVideoDisc> all = new ArrayList<>();
        all.addAll(al);
        all.remove(dvd);
        all.add(null);
        DigitalVideoDisc[] newStore = new DigitalVideoDisc[all.size()];
        newStore = (DigitalVideoDisc[]) all.toArray();
        itemsInStore = newStore;
    }
}
