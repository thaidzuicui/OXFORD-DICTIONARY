package graphic_version;

import src.dcnr.DataBase;
//import graphic_version.TextToSpeech;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class dictionaryController {
    public dictionaryController() throws IOException, SQLException {
        List<String> wordd = connector.getAll();
        allWords = FXCollections.observableArrayList(wordd);
    }

    public void initialize() throws SQLException {
        // custom listview
        Callback<ListView<String>, ListCell<String>> cellFactory = param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setFont(Font.font(18)); // Set the font size here
                }
            }
        };
        output.setCellFactory(cellFactory);

        filteredWords = new FilteredList<>(allWords);
        output.setItems(filteredWords);

        search.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            filteredWords.setPredicate(word -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                return word.toLowerCase().startsWith(lowerCaseFilter);
            });
        });
    }

    @FXML
    private TextField search;
    @FXML
    private ListView<String> output;
    @FXML
    private WebView definition;
    @FXML
    private Button speak;
    private FilteredList<String> filteredWords;
    private DataBase connector = new DataBase();
    private ObservableList<String> allWords;
    //  private TextToSpeech textToSpeech = new TextToSpeech();


    @FXML
    public void search(ActionEvent e) {
        String searchedWord = search.getText().toLowerCase();
        if (!searchedWord.isEmpty()) {
            filteredWords.setPredicate(word -> word.toLowerCase().startsWith(searchedWord));
        } else {
            filteredWords.setPredicate(word -> true); // If the search field is empty, show all words.
        }
    }

    @FXML
    public void displayDefinition(MouseEvent e) throws SQLException {
        String selectWord = output.getSelectionModel().getSelectedItem();
        String def = "";
        if (selectWord != null) {
            def = DataBase.getDefinition(selectWord);
        }

        if (!def.isEmpty()) {
            // Load HTML content into the WebView
            definition.getEngine().loadContent(def);
        }
    }

    @FXML
    public void pronounce(ActionEvent e) {
        String selectedWord = output.getSelectionModel().getSelectedItem();
//        if (selectedWord != null) {
//            textToSpeech.speakWord(selectedWord);
//        }
    }
}
