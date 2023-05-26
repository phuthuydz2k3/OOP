package test;

import test.hust.soict.dsai.aims.media.Media;

public class DigitalVideoDisc extends Media
{
    private String director;
    private int length;
    private static int nbDigitalVideoDisc = 0;

    public static int getNbDigitalVideoDisc() {
        return nbDigitalVideoDisc;
    }

    public DigitalVideoDisc()
    {
        super();
        setTitle("");
        setCategory("");
        setDirector("");
        setLength(0);
        setCost((float) 0.0);
        setId(nbDigitalVideoDisc++ + 1);
    }
    public DigitalVideoDisc(String title)
    {
        this();
        setTitle(title);
    }

    public DigitalVideoDisc(String category, String title, float cost)
    {
        this(title);
        setCategory(category);
        setCost(cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost)
    {
        this(category, title, cost);
        setDirector(director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost)
    {
        this(director, category, title, cost);
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
