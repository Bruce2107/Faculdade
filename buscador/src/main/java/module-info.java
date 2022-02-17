module br.manogarrafa.buscador {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires okhttp3;

    opens br.manogarrafa.buscador to javafx.fxml;
    exports br.manogarrafa.buscador;
}