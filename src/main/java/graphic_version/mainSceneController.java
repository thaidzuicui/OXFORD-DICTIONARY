package graphic_version;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class mainSceneController implements Initializable
{
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    }

    @FXML
    private Tab tabDictionary ;

    @FXML
    private Tab tabTranslate ;

    @FXML
    private Tab tabGame ;

    @FXML
    private Tab tabSetting ;

}
