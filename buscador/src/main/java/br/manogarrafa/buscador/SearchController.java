package br.manogarrafa.buscador;

import br.manogarrafa.buscador.utils.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;


public class SearchController {
    @FXML private TextField searchField;
    @FXML private Button searchBTN;
    @FXML private Text searchMessage;

    @FXML
    protected void onSearch() {
        if(!searchField.getText().equals("")) {
            try {
                Stage stage = (Stage) searchBTN.getScene().getWindow();

                Cinefilo cinefilo = new Cinefilo();
                cinefilo.setObserver(Search::setMovie);
                var result = cinefilo.buscar(searchField.getText());
                if (result != null && !result.equals("")) {
                    URL parent = Objects.requireNonNull(getClass().getResource("movie.fxml"));
                    new ChangeScene().changeRoute(stage, parent);
                }else {
                    searchMessage.setText("Filme não encontrado");
                    searchField.requestFocus();
                }
            }catch (Exception e) {
                searchMessage.setText("Houve um erro ao buscar seu filme");
                System.out.println(e);
            }
        }else {
            searchField.getStyleClass().add("error");
            searchMessage.setText("Informe o nome de um filme");
        }
    }

    @FXML
    protected void onClean() {
        searchField.clear();
        searchMessage.setText("");
        searchField.getStyleClass().remove("error");
        searchField.requestFocus();
    }
}
