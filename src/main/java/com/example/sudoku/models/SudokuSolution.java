package com.example.sudoku.models;

import java.util.Random;

public class SudokuSolution {

    private static final int SIZE = 6;
    private static final int BLOCK_ROWS = 2;
    private static final int BLOCK_COLS = 3;
    private final Random random = new Random();

    public int[][] generateSolution() {
        int[][] grid = new int[SIZE][SIZE];
        boolean ok = solve(grid, 0, 0);
        if (!ok) {
            throw new IllegalStateException("No se pudo generar una solución valida.");
        }
        return grid;
    }

    private boolean solve(int[][] grid, int row, int col) {
        if (row == SIZE) return true;

        int nextRow = (col == SIZE - 1) ? row + 1 : row;
        int nextCol = (col + 1) % SIZE;

        int[] numbers = {1, 2, 3, 4, 5, 6};
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

    private void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
