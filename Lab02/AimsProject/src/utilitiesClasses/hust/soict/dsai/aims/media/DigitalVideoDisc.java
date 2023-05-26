package test.hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable
{
    private String director;
    private int length;
    private static int nbDigitalVideoDisc = 0;

    public DigitalVideoDisc()
    {
        super(nbDigitalVideoDisc++ + 1, "", "", (float) 0.0);
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
    public void play()
    {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
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

    public static int getNbDigitalVideoDisc() {
        return nbDigitalVideoDisc;
    }
}
