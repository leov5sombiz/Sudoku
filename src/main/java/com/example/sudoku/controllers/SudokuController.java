package com.example.sudoku.controllers;

import com.example.sudoku.models.SudokuBoard;
import com.example.sudoku.models.SudokuSolution;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * @author Leandro Moreno Castillo
 * @version 1.0
 */

public class SudokuController {

    @FXML Label victoryMessage;

    @FXML private GridPane sudokuGridParent;

    public static TextField[][] cells = new TextField[6][6];

    SudokuSolution sudokuSolution = new SudokuSolution();
    int[][] solution = sudokuSolution.generateSolution();

    SudokuBoard sudokuBoard = new SudokuBoard();
    int[][] board = sudokuBoard.generatePuzzle(solution);

    /**
     * Generates an empty TextField which's also uneditable
     * @return the TextFields that the player has to fill to win the game
     */

    private TextField makeTextField(){
        TextField textfield = new TextField();
        textfield.setEditable(false);
        textfield.getStyleClass().add("text-field");
        return textfield;
    }

    /**
     * It basically controls the entire flow of the game
     */

    public void initialize() {

        for (int r = 0; r < 3; r++) {

            for (int c = 0; c < 2; c++) {

                GridPane block = makeGrid();
                sudokuGridParent.add(block, c, r);

                for (int fila = 0; fila < 2; fila++) {

                    for (int col = 0; col < 3; col++) {

                        TextField textfield = makeTextField();
                        block.add(textfield, col, fila);

                        int globalRow = r * 2 + fila;
                        int globalCol = c * 3 + col;

                        cells[globalRow][globalCol] = textfield;

                        textfield.setOnKeyReleased(event -> {
                            
                            String text = textfield.getText();

                            if (text.isEmpty()) {
                                textfield.setStyle("");
                                return;
                            }

                            if (!text.matches("[1-6]")) {
                                textfield.setText("");
                                return;
                            }

                            int valor = Integer.parseInt(text);

                            if (SudokuValidator.isValid(globalRow, globalCol, valor)) {
                                textfield.setStyle("");
                            } else {
                                textfield.setStyle("-fx-border-color: red; -fx-border-width: 2;");
                            }

                            if (SudokuValidator.gameCompleted()) {
                                victoryMessage.setText("Congratulations! You Win!");
                            }

                        });
                    }
                }
            }
        }
    }


    /**
     * Makes an instance of Grid Class
     * @return A grid instance named "block"
     */

    private GridPane makeGrid(){
        GridPane block = new GridPane();
        block.getStyleClass().add("parentGridBlock");
        return block;
    }

    /**
     * It's used when the player clicks "Play"
     * fills the board with some numbers and also makes it editable
     */

    @FXML
    private void onPlayClicked() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != 0) {
                    cells[i][j].setText(String.valueOf(board[i][j]));
                    cells[i][j].setStyle("-fx-background-color: lightgray;");
                    cells[i][j].setEditable(false);
                } else {
                    cells[i][j].clear();
                    cells[i][j].setEditable(true);
                }
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * It's used when the player clicks "Help"
     * fills automatically an empty box with the solution
     */

    @FXML
    private void onPlayHelp(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (cells[i][j].getText().isEmpty()) {
                    cells[i][j].setText(String.valueOf(solution[i][j]));
                    return;
                }
            }
        }
    }
}