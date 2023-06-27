package hust.soict.globalict.aims.screen;

import hust.soict.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        this.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addBtn = new JButton("Add to cart");
        addBtn.addActionListener(e -> {
            cart.addMedia(media);
        });
        container.add(addBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(new PlayListener());

            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class PlayListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Play");
            playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JLabel label = new JLabel("Playing");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));

            playDialog.add(label);
            playDialog.setSize(100, 100);
            playDialog.setLocationRelativeTo(null); // Center the dialog on the screen
            playDialog.setVisible(true);
        }
    }
}