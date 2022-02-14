module com.manogarrafa.atv2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;

    opens com.manogarrafa.atv2 to javafx.fxml;
    exports com.manogarrafa.atv2;
}