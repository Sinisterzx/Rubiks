module com.example.rubiks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rubiks to javafx.fxml;
    exports com.example.rubiks;
}