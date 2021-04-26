package edu.cuny.ccny.csc221.a5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class A5_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rBtnWhite;

    @FXML
    private ToggleGroup tgColor;

    @FXML
    private RadioButton rBtnBlack;

    @FXML
    private RadioButton rBtnGreen;

    @FXML
    private RadioButton rBtnRed;

    @FXML
    private RadioButton rBtnBlue;

    @FXML
    private RadioButton rBtnBrown;

    @FXML
    private RadioButton rBtnSmall;

    @FXML
    private ToggleGroup tgPenSize;

    @FXML
    private RadioButton rBtnMedium;

    @FXML
    private RadioButton rBtnLarge;

    @FXML
    private RadioButton rBtnXLarge;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnReset;

    @FXML
    private Label lblRGB;

    @FXML
    private Slider slideRed;

    @FXML
    private Slider slideGreen;

    @FXML
    private Slider slideBlue;

    @FXML
    private Pane panelDraw;

    private enum PenSize {

        SMALL(2),
        MEDIUM(6),
        LARGE(10),
        XLARGE(14);

        final int radius;

        PenSize(int radius) {
            this.radius = radius;
        }
    }

    private enum DrawColor {

        WHITE(Color.WHITE),
        BLACK(Color.BLACK),
        RED(Color.RED),
        GREEN(Color.GREEN),
        BLUE(Color.BLUE),
        BROWN(Color.BROWN);

        final Color color;

        DrawColor(Color color) {
            this.color = color;
        }
    }

    DrawColor drawColor = DrawColor.BLACK;
    PenSize penSize = PenSize.SMALL;

    private final ChangeListener<Number> chListBackgroundSlider = new ChangeListener<>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            String red = (slideRed.valueProperty().intValue() < 16 ? "0" : "") + Integer.toHexString(slideRed.valueProperty().intValue()).toUpperCase();
            String green = (slideGreen.valueProperty().intValue() < 16 ? "0" : "") + Integer.toHexString(slideGreen.valueProperty().intValue()).toUpperCase();
            String blue = (slideBlue.valueProperty().intValue() < 16 ? "0" : "") + Integer.toHexString(slideBlue.valueProperty().intValue()).toUpperCase();

            lblRGB.setText("#" + red + green + blue);

            panelDraw.setStyle("-fx-border-color: black; -fx-background-color: #" + red + green + blue);
        }
    };

    @FXML
    /**
     * Resets the components of the application
     */
    void resetButtonEventHandler(ActionEvent event) {

        panelDraw.getChildren().clear();

        slideRed.setValue(255);
        slideGreen.setValue(255);
        slideBlue.setValue(255);

        rBtnBlack.setSelected(true);
        rBtnSmall.setSelected(true);

        colorChangeEventHandler(null);
        penSizeChangeEventHandler(null);
    }

    @FXML
    /**
     * Called when the color radio buttons selection changes
     */
    void colorChangeEventHandler(ActionEvent event) {
        if (rBtnWhite.isSelected())
            drawColor = DrawColor.WHITE;
        else if (rBtnBlack.isSelected())
            drawColor = DrawColor.BLACK;
        else if (rBtnGreen.isSelected())
            drawColor = DrawColor.GREEN;
        else if (rBtnRed.isSelected())
            drawColor = DrawColor.RED;
        else if (rBtnBlue.isSelected())
            drawColor = DrawColor.BLUE;
        else
            drawColor = DrawColor.BROWN;
    }

    /**
     * Called when the pen radio buttons selection changes
     */
    @FXML
    void penSizeChangeEventHandler(ActionEvent event) {

        if (rBtnSmall.isSelected())
            penSize = PenSize.SMALL;
        else if (rBtnMedium.isSelected())
            penSize = PenSize.MEDIUM;
        else if (rBtnLarge.isSelected())
            penSize = PenSize.LARGE;
        else
            penSize = PenSize.XLARGE;
    }

    /**
     * Called when the mouse is dragged across the drawing panel
     */
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {

        // ensure that the circle's perimeter doesn't overflow the drawing panels
        if (panelDraw.getLayoutBounds().contains(event.getX() - penSize.radius, event.getY() - penSize.radius) &&
                panelDraw.getLayoutBounds().contains(event.getX() + penSize.radius, event.getY() + penSize.radius))
            panelDraw.getChildren().add(new Circle(event.getX(), event.getY(), penSize.radius, drawColor.color));
    }

    /**
     * Called when the undo button is clicked
     */
    @FXML
    void undoButtonEventHandler(ActionEvent event) {

        if (!panelDraw.getChildren().isEmpty())
            panelDraw.getChildren().remove(panelDraw.getChildren().size() - 1);
    }

    /**
     * Called when the save button is clicked
     */
    @FXML
    void saveButtonEventHandler(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an XML File");
        fileChooser.setInitialDirectory(new File("."));

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", "*.xml"));

        File destinationFile = fileChooser.showSaveDialog(panelDraw.getScene().getWindow());

        String fileName = destinationFile.getName();
        if (fileName.matches("^[A-Z][a-zA-Z0-9]{4,}\\.xml$")) {

            try (FileOutputStream fos = new FileOutputStream(fileName)) {

                try (XMLEncoder encoder = new XMLEncoder(fos)) {
                    for (Node child : panelDraw.getChildren()) {
                        Circle c = (Circle) child;
                        A5Circle a5Circle = new A5Circle(c.getCenterX(), c.getCenterY(), c.getRadius(), c.getFill().toString());

                        // write to xml
                        encoder.writeObject(a5Circle);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.err.println("Invalid file name: Must start with an uppercase letter, followed by 4 or more alphanumeric characters, and ending with the XML extension.");
        }
    }

    @FXML
    void initialize() {

        assert rBtnWhite != null : "fx:id=\"rBtnWhite\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgColor != null : "fx:id=\"tgColor\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnBlack != null : "fx:id=\"rBtnBlack\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnGreen != null : "fx:id=\"rBtnGreen\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnRed != null : "fx:id=\"rBtnRed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnBlue != null : "fx:id=\"rBtnBlue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnBrown != null : "fx:id=\"rBtnBrown\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnSmall != null : "fx:id=\"rBtnSmall\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgPenSize != null : "fx:id=\"tgPenSize\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnMedium != null : "fx:id=\"rBtnMedium\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnLarge != null : "fx:id=\"rBtnLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rBtnXLarge != null : "fx:id=\"rBtnXLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert lblRGB != null : "fx:id=\"lblRGB\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert slideRed != null : "fx:id=\"slideRed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert slideGreen != null : "fx:id=\"slideGreen\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert slideBlue != null : "fx:id=\"slideBlue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert panelDraw != null : "fx:id=\"panelDraw\" was not injected: check your FXML file 'Assignment5.fxml'.";

        // initial state setup
        slideRed.valueProperty().addListener(chListBackgroundSlider);
        slideGreen.valueProperty().addListener(chListBackgroundSlider);
        slideBlue.valueProperty().addListener(chListBackgroundSlider);

        chListBackgroundSlider.changed(null, null, null);
    }
}
