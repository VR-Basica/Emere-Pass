module com.example.javafxp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.javafxproject to javafx.fxml;
    exports com.example.javafxproject;
}