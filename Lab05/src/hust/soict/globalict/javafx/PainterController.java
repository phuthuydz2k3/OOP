package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController
{

    @FXML
    private Pane drawing;
    @FXML
    private RadioButton pen;
    @FXML
    private RadioButton eraser;

    @FXML
    void clearButtonPressed(ActionEvent event)
    {
        drawing.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event)
    {
        Circle newCircle = null;
        if (pen.selectedProperty().get())
        {
            newCircle = new Circle(event.getX(),
                    event.getY(), 4, Color.BLACK);
        }
        else if (eraser.selectedProperty().get())
        {
            newCircle = new Circle(event.getX(),
                    event.getY(), 4, Color.WHITE);
        }
        drawing.getChildren().add(newCircle);
    }
}
