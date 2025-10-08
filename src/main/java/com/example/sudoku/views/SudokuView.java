package com.example.sudoku.views;

import com.example.sudoku.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SudokuView extends Stage {

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

    private static class SudokuViewHolder{
        private static SudokuView INSTANCE;
    }

    public static SudokuView getInstance() throws IOException {
        if (SudokuViewHolder.INSTANCE == null) {
            return SudokuViewHolder.INSTANCE = new SudokuView();
        } else  {
            return SudokuViewHolder.INSTANCE;
        }
    }

}
