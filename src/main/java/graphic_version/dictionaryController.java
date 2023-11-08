package graphic_version;

import cmd_version.VoiceRSS;
import javafx.fxml.Initializable;
import javafx.util.Pair;
import src.dcnr.Database;
import src.dcnr.Trie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class dictionaryController implements Initializable {
    @FXML
    private TextField search;
    @FXML
    private ListView<String> output;
    @FXML
    private WebView definition;
    @FXML
    private Button speak;
    @FXML
    private Button addButton;
    @FXML
    private Button fixButton;
    @FXML
    private Button deleteButton;
    private ObservableList<String> filteredWords;
    private ObservableList<String> allWords;
    private Database database = new Database();
    private Trie trie = new Trie();

    public dictionaryController() throws IOException, SQLException {
        filteredWords = FXCollections.observableArrayList();
        List<String> word = trie.getAllWords();
        allWords = FXCollections.observableArrayList(word);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

//        if (selectWord != null) {
//            def = database.getDefinition(selectWord);
//        }

        def = trie.getDefinition(selectWord);

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

    @FXML
    public void addWord(ActionEvent event) {
        Pair<String, String> newWord = message.addWord();

        if (!newWord.getKey().equals("") && !newWord.getValue().equals("")) {
            if (trie.search(newWord.getKey())) {
                message.warning("Warning","","This word is already in the dictionary.");
                System.out.println("This word is already in the dictionary.");
            } else {
                Trie.insert(newWord.getKey(), newWord.getValue());
                System.out.println("Word has been added to the dictionary.");
            }
        }
        else if(!newWord.getKey().equals("") || !newWord.getValue().equals("")){
            message.warning("Warning","","Please fill in all fields.");
            System.out.println("Please fill in all fields.");
        }
        else {
            System.out.println("Cancel.");
        }
    }

    @FXML
    public void deleteWord(ActionEvent event) {
        String word = search.getText();
        if (word != null && !word.isEmpty()) {
            if (message.deleteWord()) {
                trie.delete(word);
                System.out.println("Word: " + word + " has been deleted.");
                search.setText("");
                definition.getEngine().loadContent("");
            } else {
                System.out.println("Cancel.");
            }
        } else {
            System.out.println("Word is not found in dictionary.");
        }
    }
}
