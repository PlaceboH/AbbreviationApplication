module com.example.abbreviationapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
    opens com.example.abbreviationapplication to javafx.fxml;
    exports com.example.abbreviationapplication;
}