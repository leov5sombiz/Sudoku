package com.example.sudoku.models;

import java.util.Random;

public class SudokuBoard {
    private static final int SIZE = 6;
    private static final int BLOCK_ROWS = 2;
    private static final int BLOCK_COLS = 3;

    public static int[][] generatePuzzle(int[][] solution) {
        int[][] puzzle = new int[SIZE][SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(solution[i], 0, puzzle[i], 0, SIZE);
        }
        for (int blockRow = 0; blockRow < SIZE; blockRow += BLOCK_ROWS) {
            for (int blockCol = 0; blockCol < SIZE; blockCol += BLOCK_COLS) {
                int removed = 0;
                while (removed < 4) {
                    int r = blockRow + random.nextInt(BLOCK_ROWS);
                    int c = blockCol + random.nextInt(BLOCK_COLS);
                    if (puzzle[r][c] != 0) {
                        puzzle[r][c] = 0;
                        removed++;
                    }
                }
            }
        }
        return puzzle;
    }
}
