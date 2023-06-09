package utilitiesClasses.hust.soict.dsai.aims.media;

public class Disc extends Media
{
    private int length;
    private String director;

    public Disc(String title, String category, float cost, int length, String director)
    {
        super(title, category, cost);
        setLength(length);
        setDirector(director);
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }
}
