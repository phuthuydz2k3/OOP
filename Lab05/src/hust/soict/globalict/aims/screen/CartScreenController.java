package hust.soict.globalict.aims.screen;

import hust.soict.Cart;
import hust.soict.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class CartScreenController {

    private Cart cart;
    private Store store;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Label totalValue;
    @FXML
    private MenuItem btnViewStore;

    public CartScreenController(Cart cart, Store store) {

        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        ObservableList<Media> observableList = FXCollections.observableArrayList(cart.getItemsOrdered());
        tblMedia.setItems(observableList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        btnPlay.setOnAction(e -> {
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
        });

        btnRemove.setOnAction(event -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media != null) {
                cart.removeMedia(media);
                tblMedia.getItems().remove(media);
                tblMedia.getSelectionModel().clearSelection();
                float totalCost = cart.totalCost();
                totalValue.setText(totalCost + "$");
            }
        });



        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {

                    @Override
                    public void changed(ObservableValue<? extends Media>
                                                obseverble, Media oldValue, Media newValue) {
                        if (newValue != null)
                        {
                            updateButtonBar(newValue);
                        }
                    }

                }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilterMedia(newValue);
            }
        });

        btnPlaceOrder.setOnAction(e -> {
            colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

            // Set the filtered media items to the table
            tblMedia.setItems(null);
            cart.setItemsOrderedEmpty();
            float totalCost = cart.totalCost();
            totalValue.setText(totalCost + "$");
        });

        float totalCost = cart.totalCost();
        totalValue.setText(totalCost + "$");

        btnViewStore.setOnAction(e -> {
            MenuItem menuItem = (MenuItem) e.getSource();
            javafx.scene.control.MenuButton parentMenuButton = (javafx.scene.control.MenuButton) menuItem.getParentPopup().getOwnerNode();
            javafx.scene.Scene currentScene = parentMenuButton.getScene();
            javafx.stage.Window currentWindow = currentScene.getWindow();
            currentWindow.hide();
            new StoreScreen(store, cart);
        });



    }

    void updateButtonBar(Media media)
    {
        btnRemove.setVisible(true);
        if (media instanceof Playable)
        {
            btnPlay.setVisible(true);
        }
        else
        {
            btnPlay.setVisible(false);
        }
    }

    void showFilterMedia(String newValue)
    {
        ObservableList<Media> filteredList = FXCollections.observableArrayList();

        if (radioBtnFilterId.selectedProperty().get())
        {
            for (Media media : cart.getItemsOrdered()) {
                if (media.getId() == Integer.parseInt(newValue)) {
                    filteredList.add(media);
                }
            }
        }
        else
        {
            for (Media media : cart.getItemsOrdered()) {
                if (media.getTitle().contains(newValue)) {
                    filteredList.add(media);
                }
            }
        }

        // Set up the cell value factories for the table columns
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Set the filtered media items to the table
        tblMedia.setItems(filteredList);
    }
}
