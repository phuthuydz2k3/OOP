package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media
{
    private List<String> authors = new ArrayList<>();
    public Book(String title, String category, float cost)
    {
        super(title, category, cost);
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
