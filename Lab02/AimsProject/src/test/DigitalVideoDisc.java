package test;

public class DigitalVideoDisc
{
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc()
    {
        setTitle("");
        setCategory("");
        setDirector("");
        setLength(0);
        setCost((float) 0.0);
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
