package hust.soict.globalict.aims.screen;

import hust.soict.Cart;
import hust.soict.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class StoreScreen extends JFrame
{
    private final Store store;
    private final Cart cart;
    private JPanel centerPanel;


    public StoreScreen(Store store, Cart cart)
    {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args)
    {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation"
                , "Roger Allers", 87, 19.95f);

        Track track = new Track("Haha", 3);
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track);

        CompactDisc cd = new CompactDisc("Java Core I", "Coding", (float) 30.00, 2
                , "None", "Tran Anh", tracks);

        Book book = new Book("C Programming", "Coding", (float) 20.00);
        book.addAuthor("Tran Anh");
        book.addAuthor("Do Hong Hai");
        book.addAuthor("Mai Duc An");

        store.addMedia(dvd);
        store.addMedia(cd);
        store.addMedia(book);
        store.setMediasId();

        SwingUtilities.invokeLater(() -> {
            StoreScreen storeScreen = new StoreScreen(store, cart);
        });
    }

    JPanel createNorth()
    {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar()
    {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBtnDVD = new JMenuItem("Add DVD");
        addBtnDVD.addActionListener(e -> {
            AddDVDToStoreScreen addDVDToStoreScreen = new AddDVDToStoreScreen(store);
            addDVDToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel); // Remove the current center panel
                        centerPanel = createCenter(); // Create a new center panel
                        getContentPane().add(centerPanel, BorderLayout.CENTER); // Add the new center panel
                        getContentPane().revalidate(); // Refresh the layout
                        getContentPane().repaint(); // Repaint the frame
                    });
                }
            });
        });
        smUpdateStore.add(addBtnDVD);

        JMenuItem addBtnCD = new JMenuItem("Add CD");
        addBtnCD.addActionListener(e -> {
            AddCDToStoreScreen addCDToStoreScreen = new AddCDToStoreScreen(store);
            addCDToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel); // Remove the current center panel
                        centerPanel = createCenter(); // Create a new center panel
                        getContentPane().add(centerPanel, BorderLayout.CENTER); // Add the new center panel
                        getContentPane().revalidate(); // Refresh the layout
                        getContentPane().repaint(); // Repaint the frame
                    });
                }
            });
        });
        smUpdateStore.add(addBtnCD);

        JMenuItem addBtnBook = new JMenuItem("Add Book");
        addBtnBook.addActionListener(e -> {
            AddBookToStoreScreen addBookToStoreScreen = new AddBookToStoreScreen(store);
            addBookToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel); // Remove the current center panel
                        centerPanel = createCenter(); // Create a new center panel
                        getContentPane().add(centerPanel, BorderLayout.CENTER); // Add the new center panel
                        getContentPane().revalidate(); // Refresh the layout
                        getContentPane().repaint(); // Repaint the frame
                    });
                }
            });
        });
        smUpdateStore.add(addBtnBook);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        JMenuItem viewCartBtn = new JMenuItem("View Cart");
        viewCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CartScreen cartScreen = new CartScreen(cart);
            }
        });
        menu.add(viewCartBtn);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader()
    {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartBtn = new JButton("View cart");
        cartBtn.addActionListener(e -> {
            CartScreen cartScreen = new CartScreen(cart);
        });
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter()
    {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < store.getItemsInStore().size(); i++)
        {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }
}
