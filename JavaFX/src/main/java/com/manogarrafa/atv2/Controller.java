package com.manogarrafa.atv2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Label msg;
    private Integer valor = 0;
    private Boolean firstRender = true;

    private void showMessage() {
        msg.setText(String.valueOf(valor));
        if(Boolean.FALSE.equals(firstRender)) {
            System.out.println("O novo valor de contador é: "+valor);
        }
    }

    @FXML
    protected void incrementar() {
        valor++;
        showMessage();
    }
    @FXML
    protected void decrementar() {
        valor--;
        showMessage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMessage();
        firstRender = false;
    }
}