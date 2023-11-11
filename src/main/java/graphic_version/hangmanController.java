package graphic_version;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class hangmanController extends hangmanMenuController {
    @FXML
    private ImageView iv;
    Image img2 = new Image(getClass().getResourceAsStream("img2.png"));
    Image img3 = new Image(getClass().getResourceAsStream("img3.png"));
    Image img4 = new Image(getClass().getResourceAsStream("img4.png"));
    Image img5 = new Image(getClass().getResourceAsStream("img5.png"));
    Image img6 = new Image(getClass().getResourceAsStream("img6.png"));
    Image img7 = new Image(getClass().getResourceAsStream("img7.png"));
    @FXML
    private Label w1;
    @FXML
    private Label w2;
    @FXML
    private Label w3;
    @FXML
    private Label w4;
    @FXML
    private Label w5;
    @FXML
    private Label w6;
    @FXML
    private Label w7;
    @FXML
    private Label w8;
    @FXML
    private Label w9;
    @FXML
    private Label w10;
    @FXML
    private Label w11;
    @FXML
    private Label centre;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button b10;
    @FXML
    private Button b11;
    @FXML
    private Button b12;
    @FXML
    private Button b13;
    @FXML
    private Button b14;
    @FXML
    private Button b15;
    @FXML
    private Button b16;
    @FXML
    private Button b17;
    @FXML
    private Button b18;
    @FXML
    private Button b19;
    @FXML
    private Button b20;
    @FXML
    private Button b21;
    @FXML
    private Button b22;
    @FXML
    private Button b23;
    @FXML
    private Button b24;
    @FXML
    private Button b25;
    @FXML
    private Button b26;
    @FXML
    private Button tgb;
    int rd = new Random().nextInt(data.size());
    String word = data.get(rd);
    int sizee = word.length();
    int life = 6;

    public void initialize() {
        tgb.setDisable(true);
        switch (sizee) {
            case 4:
                w11.setVisible(false);
                w10.setVisible(false);
                w9.setVisible(false);
                w8.setVisible(false);
                w7.setVisible(false);
                w6.setVisible(false);
                w5.setVisible(false);
                break;
            case 5:
                w11.setVisible(false);
                w10.setVisible(false);
                w9.setVisible(false);
                w8.setVisible(false);
                w7.setVisible(false);
                w6.setVisible(false);
                break;
            case 6:
                w11.setVisible(false);
                w10.setVisible(false);
                w9.setVisible(false);
                w8.setVisible(false);
                w7.setVisible(false);
                break;
            case 7:
                w11.setVisible(false);
                w10.setVisible(false);
                w9.setVisible(false);
                w8.setVisible(false);
                break;
            case 8:
                w11.setVisible(false);
                w10.setVisible(false);
                w9.setVisible(false);
                break;
            case 9:
                w11.setVisible(false);
                w10.setVisible(false);
                break;
            case 10:
                w11.setVisible(false);
                break;
            default:
                break;
        }
    }
    int correct_ans = 0;
    public void checkAnswer(String str) {
        if (word.contains(str)) {
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (String.valueOf(c).equals(str)) {
                    showAnswer(index, Character.toString(c));
                    correct_ans++;
                }
                index++;
            }
        }
        else showImage();

        if (correct_ans == word.length()) {
            centre.setText("YOU WON!!");
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b4.setDisable(true);
            b5.setDisable(true);
            b6.setDisable(true);
            b7.setDisable(true);
            b8.setDisable(true);
            b9.setDisable(true);
            b10.setDisable(true);
            b11.setDisable(true);
            b12.setDisable(true);
            b13.setDisable(true);
            b14.setDisable(true);
            b15.setDisable(true);
            b16.setDisable(true);
            b17.setDisable(true);
            b18.setDisable(true);
            b19.setDisable(true);
            b20.setDisable(true);
            b21.setDisable(true);
            b22.setDisable(true);
            b23.setDisable(true);
            b24.setDisable(true);
            b25.setDisable(true);
            b26.setDisable(true);
            tgb.setDisable(false);
            tgb.setStyle("-fx-background-color: #a29bfe");
        }
    }

    public void showAnswer(int index, String str) {
        switch (index) {
            case 0:
                w1.setText(str);
                break;
            case 1:
                w2.setText(str);
                break;
            case 2:
                w3.setText(str);
                break;
            case 3:
                w4.setText(str);
                break;
            case 4:
                w5.setText(str);
                break;
            case 5:
                w6.setText(str);
                break;
            case 6:
                w7.setText(str);
                break;
            case 7:
                w8.setText(str);
                break;
            case 8:
                w9.setText(str);
                break;
            case 9:
                w10.setText(str);
                break;
            case 10:
                w11.setText(str);
                break;
        }
    }

    public void showImage() {
        life--;
        switch (life) {
            case 5:
                iv.setImage(img2);
                break;
            case 4:
                iv.setImage(img3);
                break;
            case 3:
                iv.setImage(img4);
                break;
            case 2:
                iv.setImage(img5);
                break;
            case 1:
                iv.setImage(img6);
                break;
            case 0:
                iv.setImage(img7);
                centre.setText("GAME OVER!!");
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                b5.setDisable(true);
                b6.setDisable(true);
                b7.setDisable(true);
                b8.setDisable(true);
                b9.setDisable(true);
                b10.setDisable(true);
                b11.setDisable(true);
                b12.setDisable(true);
                b13.setDisable(true);
                b14.setDisable(true);
                b15.setDisable(true);
                b16.setDisable(true);
                b17.setDisable(true);
                b18.setDisable(true);
                b19.setDisable(true);
                b20.setDisable(true);
                b21.setDisable(true);
                b22.setDisable(true);
                b23.setDisable(true);
                b24.setDisable(true);
                b25.setDisable(true);
                b26.setDisable(true);
                tgb.setDisable(false);
                tgb.setStyle("-fx-background-color: #a29bfe");
                break;
        }
    }

    public void clicked1(ActionEvent e) {
        checkAnswer("a");
        b1.setVisible(false);
    }
    public void clicked2(ActionEvent e) {
        checkAnswer("b");
        b2.setVisible(false);
    }
    public void clicked3(ActionEvent e) {
        checkAnswer("c");
        b3.setVisible(false);
    }
    public void clicked4(ActionEvent e) {
        checkAnswer("d");
        b4.setVisible(false);
    }
    public void clicked5(ActionEvent e) {
        checkAnswer("e");
        b5.setVisible(false);
    }
    public void clicked6(ActionEvent e) {
        checkAnswer("f");
        b6.setVisible(false);
    }
    public void clicked7(ActionEvent e) {
        checkAnswer("g");
        b7.setVisible(false);
    }
    public void clicked8(ActionEvent e) {
        checkAnswer("h");
        b8.setVisible(false);
    }
    public void clicked9(ActionEvent e) {
        checkAnswer("i");
        b9.setVisible(false);
    }
    public void clicked10(ActionEvent e) {
        checkAnswer("j");
        b10.setVisible(false);
    }
    public void clicked11(ActionEvent e) {
        checkAnswer("k");
        b11.setVisible(false);
    }
    public void clicked12(ActionEvent e) {
        checkAnswer("l");
        b12.setVisible(false);
    }
    public void clicked13(ActionEvent e) {
        checkAnswer("m");
        b13.setVisible(false);
    }
    public void clicked14(ActionEvent e) {
        checkAnswer("n");
        b14.setVisible(false);
    }
    public void clicked15(ActionEvent e) {
        checkAnswer("o");
        b15.setVisible(false);
    }
    public void clicked16(ActionEvent e) {
        checkAnswer("p");
        b16.setVisible(false);
    }
    public void clicked17(ActionEvent e) {
        checkAnswer("q");
        b17.setVisible(false);
    }
    public void clicked18(ActionEvent e) {
        checkAnswer("r");
        b18.setVisible(false);
    }
    public void clicked19(ActionEvent e) {
        checkAnswer("s");
        b19.setVisible(false);
    }
    public void clicked20(ActionEvent e) {
        checkAnswer("t");
        b20.setVisible(false);
    }
    public void clicked21(ActionEvent e) {
        checkAnswer("y");
        b21.setVisible(false);
    }
    public void clicked22(ActionEvent e) {
        checkAnswer("x");
        b22.setVisible(false);
    }
    public void clicked23(ActionEvent e) {
        checkAnswer("u");
        b23.setVisible(false);
    }
    public void clicked24(ActionEvent e) {
        checkAnswer("v");
        b24.setVisible(false);
    }
    public void clicked25(ActionEvent e) {
        checkAnswer("w");
        b25.setVisible(false);
    }
    public void clicked26(ActionEvent e) {
        checkAnswer("z");
        b26.setVisible(false);
    }

    public void playagain(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hangmanMenu.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
