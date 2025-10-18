package com.example.sudoku;

import com.example.sudoku.views.SudokuView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Leandro Moreno Castillo
 * @version 1.0
 */

public class MainApp extends Application {

    /**
     * Calls the getInstance method and starts the whole project
     * @param stage the one will show the GUI
     * @throws IOException if something doesn't work
     */

    @Override
    public void start(Stage stage) throws IOException {
        SudokuView.getInstance();
    }

}
