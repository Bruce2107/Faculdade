module br.manogarrafa.buscafilme {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.manogarrafa.buscafilme to javafx.fxml;
    exports br.manogarrafa.buscafilme;
}