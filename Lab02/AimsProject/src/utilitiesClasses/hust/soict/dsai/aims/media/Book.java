package utilitiesClasses.hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media
{
    private List<String> authors = new ArrayList<String>();
    public Book(int id, String title, String category, float cost)
    {
        super(id, title, category, cost);
    }

    @Override
    public String toString()
    {
        String initialString = "{ \"Id\": \"" + this.getId() + "\" ,"
                + "\"Title\": \"" + this.getTitle() + "\", "
                + "\"Category\": \"" + this.getCategory() + "\", "
                + "\"Cost\": \"" + this.getCost() + "\", "
                + "\"Authors\": ";

        StringBuilder stringBuilder = new StringBuilder(initialString);
        for (String author : authors)
        {
            stringBuilder.append("\"" + author + "\", ");
        }
        stringBuilder.append(" }");

        return stringBuilder.toString();
    }

    public void addAuthor(String authorName)
    {
        if (!authors.contains(authorName))
        {
            authors.add(authorName);
        }
    }
}
