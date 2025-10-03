package com.example.sudoku;

import com.example.sudoku.views.SudokuView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SudokuView.getInstance();
    }
}
