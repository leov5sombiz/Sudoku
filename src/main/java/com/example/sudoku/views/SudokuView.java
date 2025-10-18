package com.example.sudoku.views;

import com.example.sudoku.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Leandro Moreno Castillo
 * @version 1.0
 */

public class SudokuView extends Stage {

    /**
     * The information of the GUI that will be shown to the player
     * @throws IOException if something doesn't work
     */

    public SudokuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("sudoku-view.fxml"));
        Scene scene =new Scene(loader.load());
        setTitle("Lest's play Sudoku!");
        setScene(scene);
        getIcons().add(new Image(Objects.requireNonNull(
                MainApp.class.getResourceAsStream("sudoku.png")
        )));
        show();
    }

    /**
     * Initialize a static instance of SudokuView
     */

    private static class SudokuViewHolder{
        private static SudokuView INSTANCE;
    }

    /**
     * When you call this method it will return the instance of SudokuView initialized before
     * @return an instance of SudokuView
     * @throws IOException if something doesn't work
     */

    public static SudokuView getInstance() throws IOException {
        if (SudokuViewHolder.INSTANCE == null) {
            return SudokuViewHolder.INSTANCE = new SudokuView();
        } else  {
            return SudokuViewHolder.INSTANCE;
        }
    }

}
