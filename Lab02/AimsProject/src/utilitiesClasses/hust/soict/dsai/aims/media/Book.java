package test.hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media
{
    private List<String> authors = new ArrayList<String>();
    public Book(int id, String title, String category, float cost)
    {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName)
    {
        if (!authors.contains(authorName))
        {
            authors.add(authorName);
        }
    }
}
