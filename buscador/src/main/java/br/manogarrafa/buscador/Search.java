package br.manogarrafa.buscador;

import br.manogarrafa.buscador.utils.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Search extends Application {
    private static Movie movie;

    public static Movie getMovie() {
        return movie;
    }

    public static void setMovie(Movie movie) {
        Search.movie = movie;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Search.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}