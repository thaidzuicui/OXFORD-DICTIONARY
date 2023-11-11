package graphic_version;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class hangmanMenuController {
    @FXML
    private Label note;
    @FXML
    private TextField myTF;
    @FXML
    private ChoiceBox<Integer> myCB  = new ChoiceBox<>();
    @FXML
    private Button play;
    List<String> word = new ArrayList<>();
    static List<String> data = new ArrayList<>();
    int lengthOfWord;
    public void submit(ActionEvent e) throws IOException {
        String w = myTF.getText();
        if (w.length() > 11 || w.length() < 4) {
            note.setText("Note: 4 <= word's length <= 11");
            note.setTextFill(Color.RED);
            myTF.setText("");
        }
        else {
            note.setText("SUCCESSFUL");
            note.setTextFill(Color.GREEN);
            myTF.setText("");
            word.add(w);
            writeData();
        }
    }

    public void chooseLength(ActionEvent e) {
        lengthOfWord = myCB.getValue();
        switch (lengthOfWord) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                filterDataByLength(lengthOfWord);
                play.setDisable(false);
                for (int i = 0; i < data.size(); i++) {
                    System.out.println(data.get(i));
                }
                break;
            default:
                break;
        }
    }

    public void setUp() {
        myCB.getItems().addAll(4, 5, 6, 7, 8, 9, 10, 11);
        myCB.setOnAction(this::chooseLength);
        try {
            readData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hangman.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void readData() throws IOException {
        File f = new File("src\\main\\java\\cmd_version\\wfhm.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;
            word.add(line);
        }
        fr.close();
        br.close();
    }

    public void writeData() throws IOException {
        File f = new File("src\\main\\java\\cmd_version\\wfhm.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String s : word) {
            bw.write(s + "\n");
        }
        bw.flush();
        fw.close();
        bw.close();
    }

    private void filterDataByLength(int wordLength) {
        data.clear();
        for (String w : word) {
            if (w.length() == wordLength) {
                data.add(w);
            }
        }
    }

    public void initialize() {
        setUp();
    }
}

