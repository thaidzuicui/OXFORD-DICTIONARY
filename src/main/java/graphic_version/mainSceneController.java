package graphic_version;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class mainSceneController implements Initializable
{
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab == tabDictionary) {
                // Xử lý khi chuyển đến tab Dictionary
                System.out.println("Chuyển đến tab Dictionary");
            } else if (newTab == tabTranslate) {
                // Xử lý khi chuyển đến tab Translate
                System.out.println("Chuyển đến tab Translate");
            } else if (newTab == tabGame) {
                // Xử lý khi chuyển đến tab Game
                System.out.println("Chuyển đến tab Game");
            } else if (newTab == tabSetting) {
                // Xử lý khi chuyển đến tab Setting
                System.out.println("Chuyển đến tab Setting");
            }
        });
    }

    @FXML
    private Tab tabDictionary ;

    @FXML
    private Tab tabTranslate ;

    @FXML
    private Tab tabGame ;

    @FXML
    private Tab tabSetting ;

    @FXML
    private TabPane tabPane;







}
