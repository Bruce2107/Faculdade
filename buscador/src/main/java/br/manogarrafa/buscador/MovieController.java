package br.manogarrafa.buscador;

import br.manogarrafa.buscador.utils.Movie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;


public class MovieController implements Initializable {
    @FXML
    private ImageView moviePoster;
    @FXML
    private Text movieRated;
    @FXML
    private Text movieRuntime;
    @FXML
    private Text movieGenre;
    @FXML
    private Text movieRating;
    @FXML
    private Text movieDirector;
    @FXML
    private Text movieAwards;
    @FXML
    private Text movieCountry;
    @FXML
    private Text movieLanguage;
    @FXML
    private TextFlow movieTitle;
    @FXML
    private Text movieRelease;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Movie movie = Search.getMovie();

        movieTitle.getChildren().add(new Text(movie.name));
        movieRelease.setText("Lançamento: %s".formatted(movie.releaseDate));
        movieRated.setText("Classifição: %s".formatted(movie.rated));
        movieRuntime.setText("Duração: %s".formatted(movie.runtime));
        movieGenre.setText("Gênero: %s".formatted(movie.genre));
        movieRating.setText("Nota: %s".formatted(movie.rating));
        movieDirector.setText("Diretor: %s".formatted(movie.director));
        movieAwards.setText("Prêmios: %s".formatted(movie.awards));
        movieCountry.setText("País: %s".formatted(movie.country));
        movieLanguage.setText("Idioma: %s".formatted(movie.language));
        moviePoster.setImage(new Image(movie.poster));
    }
}
