package hust.soict.globalict.aims.screen;

import hust.soict.dsai.aims.media.Track;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddTracksScreen extends JFrame
{
    public AddTracksScreen(int numberOfTracks, ArrayList<Track> tracks)
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(numberOfTracks * 2 + 1, 2));

        JTextField[] tfTitles = new JTextField[numberOfTracks];
        JTextField[] tfLengths = new JTextField[numberOfTracks];
        for (int i = 1; i <= numberOfTracks; i++)
        {
            JTextField tfTitle = new JTextField(10);
            cp.add(new JLabel("Title Track " + i));
            cp.add(tfTitle);
            tfTitles[i - 1] = tfTitle;

            JTextField tfLength = new JTextField(10);
            cp.add(new JLabel("Length Track " + i));
            cp.add(tfLength);
            tfLengths[i - 1] = tfLength;
        }

        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        buttonPanel.setLayout(new GridLayout(1, 2)); // Set the layout to 1 row and 2 columns
        buttonPanel.add(submitButton); // Add the button to the buttonPanel
        submitButton.addActionListener(e -> {
            for (int i = 0; i < numberOfTracks; i++)
            {
                tracks.add(new Track(tfTitles[i].getText(), Integer.parseInt(tfLengths[i].getText())));
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

//    public static void main(String[] args)
//    {
//        new AddTracksScreen(5);
//    }
}
