package com.example.sudoku.controllers;

import static com.example.sudoku.controllers.SudokuController.cells;

/**
 * @author Leandro Moreno Castillo
 * @version 1.0
 */

public class SudokuValidator {

    /**
     * Is used when the player enters a number to verify if it's correct
     * @param fila which is located
     * @param col which is located
     * @param valor the number that the player has entered
     * @return True if the number is valid according to the rules
     */

    public static boolean isValid(int fila, int col, int valor) {

        if (valor < 1 || valor > 6) return false;

        for (int j = 0; j < 6; j++) {
            if (j != col && cells[fila][j].getText().equals(String.valueOf(valor))) {
                return false;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (i != fila && cells[i][col].getText().equals(String.valueOf(valor))) {
                return false;
            }
        }

        int startRow = (fila / 2) * 2;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 2; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (!(i == fila && j == col) && cells[i][j].getText().equals(String.valueOf(valor))) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * It's used to show an alert to the player when they've completed the game
     * @return true
     */

    public static boolean gameCompleted() {

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                String text = cells[i][j].getText();

                if (text.isEmpty()) {
                    return false;
                }

                int valor = Integer.parseInt(text);

                if (!isValid(i, j, valor)) {
                    return false;
                }
            }
        }

        return true;
    }
}