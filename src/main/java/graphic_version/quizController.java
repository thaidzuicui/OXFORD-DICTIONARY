package graphic_version;

import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class quizController {
    @FXML
    private Label question;
    @FXML
    private Label optA;
    @FXML
    private Label optB;
    @FXML
    private Label optC;
    @FXML
    private Label optD;
    @FXML
    private Label seconds_left;
    @FXML
    private Label correctGuess;
    @FXML
    private Label comment;
    @FXML
    private Button bA;
    @FXML
    private Button bB;
    @FXML
    private Button bC;
    @FXML
    private Button bD;
    String[] questions = {
            "My English teacher is ………… the United States.",
            "They have two sons. ………. sons are students.",
            "…..…. Jane beautiful?",
            "He …….. a teacher.",
            "How much ………. those pencils?"
    };

    String[][] opts = {
            {"from", "her", "his", "to"},
            {"our", "her", "their", "they"},
            {"is", "does", "are", "am"},
            {"am", "is", "are", "does"},
            {"is", "does", "do", "are"}
    };
    char[] ans = {
            'A',
            'C',
            'A',
            'B',
            'D'
    };

    char guess;
    int index = 0;
    int seconds = 10;
    int correct_ans = 0;

    Timeline timer;

    public void initialize() {
        this.timer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                seconds--;
                seconds_left.setText(String.valueOf(seconds));
                if (seconds <= 0) {
                    displayAnswer();
                }
            }
        }));

        this.timer.setCycleCount(Timeline.INDEFINITE);

        // Load the first question.
        loadQuestion();
    }

    public void loadQuestion() {
        if(index >= 4) {
            result();
        }
        else {
            question.setText(questions[index]);
            optA.setText(opts[index][0]);
            optB.setText(opts[index][1]);
            optC.setText(opts[index][2]);
            optD.setText(opts[index][3]);
            timer.play();
        }
    }

    public void displayAnswer() {
        timer.stop();
        if (ans[index] != 'A') optA.setTextFill(Color.RED);
        if (ans[index] != 'B') optB.setTextFill(Color.RED);
        if (ans[index] != 'C') optC.setTextFill(Color.RED);
        if (ans[index] != 'D') optD.setTextFill(Color.RED);
        Timeline pause = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                optA.setTextFill(Color.BLACK);
                optB.setTextFill(Color.BLACK);
                optC.setTextFill(Color.BLACK);
                optD.setTextFill(Color.BLACK);
                guess = ' ';
                index++;
                seconds = 10;
                seconds_left.setText("10");
                loadQuestion();
            }
        }));
        pause.setCycleCount(1);
        pause.play();
    }

    public void result() {
        question.setText("!RESULT!");
        optA.setText("");
        optB.setText("");
        optC.setText("");
        optD.setText("");
        bA.setDisable(true);
        bB.setDisable(true);
        bC.setDisable(true);
        bD.setDisable(true);
        correctGuess.setText("(" + correct_ans + " / 5)");
        if (correct_ans == 0) comment.setText("DISAPPOINTED:(");
        if (correct_ans == 1) comment.setText("YOU CAN DO BETTER");
        if (correct_ans == 2) comment.setText("NOT GOOD");
        if (correct_ans == 3) comment.setText("GOOD");
        if (correct_ans == 4) comment.setText("VERY GOOD!");
        if (correct_ans == 5) comment.setText("EXCELLENT!!");
        correctGuess.setVisible(true);
        comment.setVisible(true);

    }
    boolean checkAnswer(char answer) {
        return answer == ans[index];
    }

    public void opt1clicked(ActionEvent e) {
        guess = 'A';
        if (checkAnswer(guess)) {
            correct_ans++;
        }
        displayAnswer();
    }

    public void opt2clicked(ActionEvent e) {
        guess = 'B';
        if (checkAnswer(guess)) {
            correct_ans++;
        }
        displayAnswer();
    }

    public void opt3clicked(ActionEvent e) {
        guess = 'C';
        if (checkAnswer(guess)) {
            correct_ans++;
        }
        displayAnswer();
    }

    public void opt4clicked(ActionEvent e) {
        guess = 'D';
        if (checkAnswer(guess)) {
            correct_ans++;
        }
        displayAnswer();
    }

    public void switchBack(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
