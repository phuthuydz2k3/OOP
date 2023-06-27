package main;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter
{
    public static void main(String[] args)
    {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        objectWrapper jungleDVDWrapper = new objectWrapper(jungleDVD);
        objectWrapper cinderellaDVDWapper = new objectWrapper(cinderellaDVD);
        swap1(jungleDVD, cinderellaDVD);
        System.out.println("Wrong swap\njungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        swap2(jungleDVDWrapper, cinderellaDVDWapper);
        System.out.println("Correct swap\njungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        swap2(jungleDVDWrapper, cinderellaDVDWapper);

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    static class objectWrapper {
        DigitalVideoDisc innerObject;
        public objectWrapper(DigitalVideoDisc objInner) {
            this.innerObject = objInner;
        }
    }

    public static void swap1(Object o1, Object o2)
    {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
    public static void swap2(objectWrapper o1, objectWrapper o2)
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
