package hust.soict.dsai.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Media implements Playable
{
    private String director;
    private int length;

    public DigitalVideoDisc()
    {
        super("", "", (float) 0.0);
        setDirector("");
        setLength(0);
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

    @Override
    public void play() throws PlayerException
    {
        if (this.getLength() > 0)
        {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else
        {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString()
    {
        return "{ \"Id\": \"" + this.getId() + "\" ,"
                + "\"Title\": \"" + this.getTitle() + "\", "
                + "\"Category\": \"" + this.getCategory() + "\", "
                + "\"Director\": \"" + this.director + "\", "
                + "\"Cost\": \"" + this.getCost() + "\", "
                + "\"Length\": \"" + this.length + "\" }";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
