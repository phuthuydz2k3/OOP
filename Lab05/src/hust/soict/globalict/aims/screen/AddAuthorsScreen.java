package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddAuthorsScreen extends JFrame
{
    public AddAuthorsScreen(int numberOfAuthors, ArrayList<String> authors)
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(numberOfAuthors + 1, 2));

        JTextField[] tfAuthors = new JTextField[numberOfAuthors];
        for (int i = 1; i <= numberOfAuthors; i++)
        {
            JTextField tfAuthor = new JTextField(10);
            cp.add(new JLabel("Author Name " + i));
            cp.add(tfAuthor);
            tfAuthors[i - 1] = tfAuthor;
        }

        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        buttonPanel.setLayout(new GridLayout(1, 2)); // Set the layout to 1 row and 2 columns
        buttonPanel.add(submitButton); // Add the button to the buttonPanel
        submitButton.addActionListener(e -> {
            for (int i = 0; i < numberOfAuthors; i++)
            {
                authors.add(tfAuthors[i].getText());
            }

            this.dispose();
        });

        cp.add(new JLabel()); // Add an empty label to occupy the first column
        cp.add(buttonPanel);
        setTitle("Add Track");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
