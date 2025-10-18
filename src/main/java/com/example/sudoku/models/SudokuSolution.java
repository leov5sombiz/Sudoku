package com.example.sudoku.models;

import java.util.Arrays;
import java.util.List;
import static java.util.Collections.shuffle;

/**
 * @author Leandro Moreno Castillo
 * @version 1.0
 */

public class SudokuSolution {

    private static final int SIZE = 6;
    private static final int BLOCK_ROWS = 2;
    private static final int BLOCK_COLS = 3;

    /**
     * Generate a 6x6 solved board of sudoku
     * @return An integer array called grid which's the solution of the game
     */

    public int[][] generateSolution() {
        int[][] grid = new int[SIZE][SIZE];
        boolean ok = solve(grid, 0, 0);
        if (!ok) {
            throw new IllegalStateException("We couldn't solve the solution");
        }
        return grid;
    }

    /**
     * It's used to fill the board correctly
     * @param grid the solved board
     * @param row which is located
     * @param col which is located
     * @return false
     */

    private boolean solve (int[][] grid, int row, int col) {
        if (row == SIZE) return true;

        int nextRow = (col == SIZE - 1) ? row + 1 : row;
        int nextCol = (col + 1) % SIZE;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        shuffle(numbers);

        for (int num : numbers) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                if (solve(grid, nextRow, nextCol)) return true;
                grid[row][col] = 0;
            }
        }

        return false;
    }

    /**
     * Verifies if a number can be placed in a position on the board according to the rules
     * @param grid the solved board
     * @param row which is located
     * @param col which is located
     * @param num the number we want to verify
     * @return true
     */

    private boolean isSafe(int[][] grid, int row, int col, int num) {

        for (int i = 0; i < SIZE; i++) {
            if (grid[row][i] == num) return false;
            if (grid[i][col] == num) return false;
        }

        int startRow = (row / BLOCK_ROWS) * BLOCK_ROWS;
        int startCol = (col / BLOCK_COLS) * BLOCK_COLS;

        for (int r = startRow; r < startRow + BLOCK_ROWS; r++) {
            for (int c = startCol; c < startCol + BLOCK_COLS; c++) {
                if (grid[r][c] == num) return false;
            }
        }

        return true;
    }

}
