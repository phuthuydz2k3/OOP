package hust.soict.globalict.aims.screen;

import hust.soict.Store;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AddCDToStoreScreen extends JFrame implements AddItemToStoreScreen
{
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;
    private JTextField tfArtist;
    private JTextField tfTracks;

    public AddCDToStoreScreen(Store store)
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(8, 2));

        tfTitle = new JTextField(10);
        cp.add(new JLabel("Title: "));
        cp.add(tfTitle);

        tfCategory = new JTextField(10);
        cp.add(new JLabel("Category: "));
        cp.add(tfCategory);

        tfDirector = new JTextField(10);
        cp.add(new JLabel("Director: "));
        cp.add(tfDirector);

        tfLength = new JTextField(10);
        cp.add(new JLabel("Length: "));
        cp.add(tfLength);

        tfCost = new JTextField(10);
        cp.add(new JLabel("Cost: "));
        cp.add(tfCost);

        tfArtist = new JTextField(10);
        cp.add(new Label("Artist: "));
        cp.add(tfArtist);

        tfTracks = new JTextField(10);
        cp.add(new Label("Enter number of tracks: "));
        cp.add(tfTracks);

        JPanel buttonPanel = new JPanel(); // Use a JPanel for the button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());
            String artist = tfArtist.getText();
            ArrayList<Track> tracks = new ArrayList<Track>();
            AddTracksScreen addTracksScreen = new AddTracksScreen(Integer.parseInt(tfTracks.getText()), tracks);

            addTracksScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    Media media = new CompactDisc(title, category, cost, length, director, artist, tracks);
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
