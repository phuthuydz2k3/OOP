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
    public static final Comparator<Media> COMPARE_BY_ID = new MediaComparatorsSortById();
    public Media(String title, String category, float cost)
    {
        setId(0);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Media))
        {
            return false;
        }

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
