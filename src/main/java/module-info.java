module src.dcnr {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.dcnr to javafx.fxml;
    exports src.dcnr;
}