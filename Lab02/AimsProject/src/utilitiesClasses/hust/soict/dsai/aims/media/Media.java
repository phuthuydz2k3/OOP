package utilitiesClasses.hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media
{
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorSortByTitle();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorSortByCost();
    public Media(int id, String title, String category, float cost)
    {
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    @Override
    public boolean equals(Object obj)
    {
        Media media = (Media) obj;
        return this.title.equals(media.title);
    }

    public static void main(String[] args)
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public float getCost()
    {
        return cost;
    }

    public void setCost(float cost)
    {
        this.cost = cost;
    }
}
