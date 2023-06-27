package hust.soict.globalict.aims.screen;

import hust.soict.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AddBookToStoreScreen extends JFrame implements AddItemToStoreScreen
{
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store)
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6, 2));

        tfTitle = new JTextField(10);
        cp.add(new JLabel("Title: "));
        cp.add(tfTitle);

        tfCategory = new JTextField(10);
        cp.add(new JLabel("Category: "));
        cp.add(tfCategory);

        tfCost = new JTextField(10);
        cp.add(new JLabel("Cost: "));
        cp.add(tfCost);

        tfAuthors = new JTextField(10);
        cp.add(new JLabel("Nubmer of Authors: "));
        cp.add(tfAuthors);

        JPanel buttonPanel = new JPanel(); // Use a JPanel for the button

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            ArrayList<String> authors = new ArrayList<>();

            AddAuthorsScreen addAuthorsScreen = new AddAuthorsScreen(Integer.parseInt(tfAuthors.getText()), authors);

            addAuthorsScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    Book book = new Book(title, category, cost);
                    for (String author : authors)
                    {
                        book.addAuthor(author);
                    }
                    Media media = (Media) book;
                    store.addMedia(media);
                    dispose();
                }
            });
        });

        buttonPanel.setLayout(new GridLayout(1, 2)); // Set the layout to 1 row and 2 columns
        buttonPanel.add(submitButton); // Add the button to the buttonPanel

        cp.add(new JLabel()); // Add an empty label to occupy the first column
        cp.add(buttonPanel); // Add the buttonPanel to the container

        setTitle("Add");
        setSize(350, 225);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
