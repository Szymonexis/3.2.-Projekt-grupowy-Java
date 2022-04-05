package com.example.projekt6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HelloController {
    public GridPane gridPane;
    public ColorPicker colorPicker;
    public ComboBox<Integer> xValComboBox;
    public ComboBox<Integer> yValComboBox;
    public Label xValLabel;
    public Label yValLabel;
    public Button insertButton;
    public Button clearButton;

    private final Integer x = 10;
    private final Integer y = 10;
    private final Color defaultColor = Color.BLACK;
    private Integer currentXVal = null;
    private Integer currentYVal = null;
    private Node[][] gridPaneArray = null;
    private Color[][] gridPaneColorArray = null;

    @FXML
    public void initialize() {
        initializeGridPane();
        initializeGridPaneColorArray();
        initializeGridPaneArray();

        ObservableList<Integer> listOfX = FXCollections.observableArrayList();
        ObservableList<Integer> listOfY = FXCollections.observableArrayList();
        for (int i = 0; i < x; i++) {
            listOfX.add(i);
        }
        for (int i = 0; i < y; i++) {
            listOfY.add(i);
        }
        xValComboBox.setItems(listOfX);
        yValComboBox.setItems(listOfY);

        xValLabel.setText("X value: ");
        yValLabel.setText("Y value: ");
    }

    private void initializeGridPane() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                gridPane.add(new Pane(), i, j);
            }
        }

        ColumnConstraints col = new ColumnConstraints();
        col.setHgrow(Priority.SOMETIMES);
        RowConstraints row = new RowConstraints();
        row.setVgrow(Priority.SOMETIMES);
        for (int i = 0; i < x; i++) {
            gridPane.getColumnConstraints().addAll(col);
        }
        for (int i = 0; i < y; i++) {
            gridPane.getRowConstraints().addAll(row);
        }
    }

    private void initializeGridPaneColorArray() {
        gridPaneColorArray = new Color[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                gridPaneColorArray[i][j] = defaultColor;
            }
        }
    }

    private void initializeGridPaneArray()
    {
        gridPaneArray = new Node[x][y];

        for(Node node : gridPane.getChildren())
        {
            gridPaneArray
                    [GridPane.getRowIndex(node)]
                    [GridPane.getColumnIndex(node)] = node;

            Pane tempPane = (Pane) node;
            tempPane.setBackground(new Background(
                    new BackgroundFill(
                            defaultColor,
                            new CornerRadii(0),
                            new Insets(0))));

            node.setOnMouseMoved(event -> {
                Pane pane = (Pane) node;
                pane.setBackground(new Background(
                        new BackgroundFill(
                        colorPicker.getValue(),
                        new CornerRadii(0),
                        new Insets(0))));
            });

            node.setOnMouseExited(event -> {
                Pane pane = (Pane) node;
                int posX = -1;
                int posY = -1;

                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if(gridPaneArray[i][j] == node) {
                            posX = i;
                            posY = j;
                            break;
                        }
                    }
                }

                pane.setBackground(new Background(
                        new BackgroundFill(
                                gridPaneColorArray[posX][posY],
                                new CornerRadii(0),
                                new Insets(0))));
            });

            node.setOnMouseClicked(event -> {
                Pane pane = (Pane) node;
                Integer posX = -1;
                Integer posY = -1;

                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if(gridPaneArray[i][j] == node) {
                            posX = i;
                            posY = j;
                            break;
                        }
                    }
                }

                xValLabel.setText("X value: " + posX);
                yValLabel.setText("Y value: " + posY);
                xValComboBox.setValue(posX);
                yValComboBox.setValue(posY);
                gridPaneColorArray[posX][posY] = colorPicker.getValue();

                pane.setBackground(new Background(
                        new BackgroundFill(
                                gridPaneColorArray[posX][posY],
                                new CornerRadii(0),
                                new Insets(0))));
            });
        }
    }

    public void onSetXVal(ActionEvent actionEvent) {
        currentXVal = xValComboBox.getValue();
        xValLabel.setText("X value: " + currentXVal);
    }

    public void onSetYVal(ActionEvent actionEvent) {
        currentYVal = yValComboBox.getValue();
        yValLabel.setText("Y value: " + currentYVal);
    }

    public void onSetSquareColor(ActionEvent actionEvent) {
        gridPaneColorArray[currentXVal][currentYVal] = colorPicker.getValue();
        Pane pane = (Pane) gridPaneArray[currentXVal][currentYVal];

        pane.setBackground(new Background(
                new BackgroundFill(
                        gridPaneColorArray[currentXVal][currentYVal],
                        new CornerRadii(0),
                        new Insets(0))));
    }

    public void onClearCanvas(ActionEvent actionEvent) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                gridPaneColorArray[i][j] = defaultColor;
                Pane pane = (Pane) gridPaneArray[i][j];
                pane.setBackground(new Background(
                        new BackgroundFill(
                                defaultColor,
                                new CornerRadii(0),
                                new Insets(0))));
            }
        }
    }
}