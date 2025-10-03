package com.example.sudoku.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuController {

    @FXML
    private GridPane sudokuGrid;

    @FXML
    private void onPlayClicked() {
        for (Node node : sudokuGrid.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setEditable(true);
            }
        }

    }
}
