module src.dcnr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;
    requires voicerss.tts;
    requires javafx.media;


    opens src.dcnr to javafx.fxml;
    exports src.dcnr;
    opens graphic_version to javafx.fxml;
    exports graphic_version;
    opens cmd_version to javafx.fxml;
    exports cmd_version;
}