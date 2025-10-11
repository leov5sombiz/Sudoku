package com.example.sudoku.models;

import java.util.Random;

public class SudokuBoard {
    private static final int SIZE = 6;
    private static final int BLOCK_ROWS = 2;
    private static final int BLOCK_COLS = 3;
    private final Random random = new Random();

    public int[][] generatePuzzle(int[][] solution) {
        int[][] puzzle = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) System.arraycopy(solution[i], 0, puzzle[i], 0, SIZE);

        for (int br = 0; br < SIZE; br += BLOCK_ROWS) {
            for (int bc = 0; bc < SIZE; bc += BLOCK_COLS) {
                int removed = 0;
                while (removed < 4) {
                    int r = br + random.nextInt(BLOCK_ROWS);
                    int c = bc + random.nextInt(BLOCK_COLS);
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
