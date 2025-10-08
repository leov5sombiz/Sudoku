package com.example.sudoku.models;

import java.util.Random;

public class SudokuSolution {

    private static final int SIZE = 6;
    private static final int[][] grid = new int[SIZE][SIZE];
    private static final Random random = new Random();

    public static int[][] generateSolution() {
        solve(0, 0);
        return grid;
    }

    private static boolean solve(int row, int col) {
        if (row == SIZE)
            return true;

        int nextRow = (col == SIZE - 1) ? row + 1 : row;
        int nextCol = (col + 1) % SIZE;

        int[] numbers = {1, 2, 3, 4, 5, 6};
        shuffle(numbers);

        for (int num : numbers) {
            if (isSafe(row, col, num)) {
                grid[row][col] = num;
                if (solve(nextRow, nextCol))
                    return true;
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[row][i] == num || grid[i][col] == num)
                return false;
        }
        return true;
    }

    private static void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
