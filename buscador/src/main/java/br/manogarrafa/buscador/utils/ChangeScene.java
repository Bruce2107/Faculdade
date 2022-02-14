package br.manogarrafa.buscador.utils;

import br.manogarrafa.buscador.MovieController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ChangeScene {
    public void changeRoute(Stage stage, URL fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(fxmlFile);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
