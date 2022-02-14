package br.manogarrafa.buscador;

import br.manogarrafa.buscador.utils.Movie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MovieController implements Initializable {
    private Movie movie;
    @FXML
    private VBox screen;

    @FXML
    protected void onClick() throws IOException {
//        Sout.println(movie);
        System.out.println(movie);
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (movie != null)
            System.out.println(movie);
    }
}
