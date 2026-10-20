module com.example.pocasie {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.pocasie to javafx.fxml;
    exports com.example.pocasie;
}
