package graphic_version;

import cmd_version.VoiceRSS;
import src.dcnr.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import src.dcnr.Trie;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class dictionaryController {
    @FXML
    private TextField search;
    @FXML
    private ListView<String> output;
    @FXML
    private WebView definition;
    @FXML
    private Button speak;
    @FXML
    private DialogPane deleteDialog;
    private ObservableList<String> filteredWords;
    private ObservableList<String> allWords;
    private Database database = new Database();
    private Trie trie = new Trie();


    public dictionaryController() throws IOException, SQLException {
        filteredWords = FXCollections.observableArrayList();
        List<String> word = trie.getAllWords();
        allWords = FXCollections.observableArrayList(word);
    }

    @FXML
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
                    setFont(Font.font(16)); // Set the font size here
                }
            }
        };
        output.setCellFactory(cellFactory);


        filteredWords.addAll(allWords);
        output.setItems(filteredWords);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            String prefix = newValue.toLowerCase();
            filteredWords.clear();

            if (prefix.isEmpty()) {
                filteredWords.addAll(allWords);  // If the prefix is empty, show all words
            } else {
                try {
                    List<String> words = trie.findWordsWithPrefix(prefix); // Find words with the given prefix using the Trie
                    filteredWords.addAll(words);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    @FXML
    public void search(ActionEvent e) {
        String prefix = search.getText().toLowerCase();
        filteredWords.clear();

        if (prefix.isEmpty()) {
            // If the prefix is empty, show all words
            filteredWords.addAll(allWords);
        } else {
            // Find words with the given prefix using the Trie
            List<String> words = trie.findWordsWithPrefix(prefix);
            filteredWords.addAll(words);
        }
    }

    @FXML
    public void displayDefinition(MouseEvent e) throws SQLException {
        String selectWord = output.getSelectionModel().getSelectedItem();
        String def = "";
        if (selectWord != null) {
            search.setText(selectWord);
        }
        if (selectWord != null) {
            def = database.getDefinition(selectWord);
        }

        if (!def.isEmpty()) {
            definition.getEngine().loadContent(def); // Load HTML content into the WebView
        }
    }

    String nameFrom;
    String speakFrom;

    @FXML
    public void pronounce(ActionEvent e) throws Exception {
        nameFrom = "Linda";
        speakFrom = "en-gb";
        VoiceRSS.Name = nameFrom;
        VoiceRSS.language = speakFrom;
        if (!Objects.equals(search.getText(), "")) {
            VoiceRSS.speakWord(search.getText());
        }
    }
}
