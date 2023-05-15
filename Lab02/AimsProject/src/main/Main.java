package main;

import test.*;

public class Main
{
    public static void main(String[] args)
    {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation"
                , "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDics(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction"
                , "Geogre Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDics(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation"
                , "Roger Allers",18.99f);
        anOrder.addDigitalVideoDics(dvd3);

        System.out.println("Total cost before remove dvd1 is: " + anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(dvd1);
        System.out.println("Total cost after remove dvd1 is: " + anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total cost after remove dvd2 is: " + anOrder.totalCost());
    }

    static class objectWrapper {
        DigitalVideoDisc innerObject;
        public objectWrapper(DigitalVideoDisc objInnner) {
            this.innerObject = objInnner;
        }
    }

    public static void swap(objectWrapper o1, objectWrapper o2)
    {
        DigitalVideoDisc temp;
        temp = o1.innerObject;
        o1.innerObject = o2.innerObject;
        o2.innerObject = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title)
    {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
