package graphic_version;

import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import javafx.animation.Timeline;
import javafx.util.Duration;

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

    public void initialize() {
        loadQuestion();
    }

    public void loadQuestion() {
        question.setText(questions[index]);
        optA.setText(opts[index][0]);
        optB.setText(opts[index][1]);
        optC.setText(opts[index][2]);
        optD.setText(opts[index][3]);
    }

    boolean checkAnswer(char answer) {
        return answer == ans[index];
    }
    public void opt1clicked(ActionEvent e) {
        guess = 'A';
        if(checkAnswer(guess)) {}
        optB.setTextFill(Color.RED);
        optC.setTextFill(Color.RED);
        optD.setTextFill(Color.RED);
        Timeline pause = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                optA.setTextFill(Color.BLACK);
                optB.setTextFill(Color.BLACK);
                optC.setTextFill(Color.BLACK);
                optD.setTextFill(Color.BLACK);
                guess = ' ';
                index++;
                loadQuestion();
            }
        }));
        pause.setCycleCount(1);
        pause.play();
    }

    public void opt2clicked(ActionEvent e) {
        guess = 'B';
        if(checkAnswer(guess)) {}
        optA.setTextFill(Color.RED);
        optC.setTextFill(Color.RED);
        optD.setTextFill(Color.RED);
        Timeline pause = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                optA.setTextFill(Color.BLACK);
                optB.setTextFill(Color.BLACK);
                optC.setTextFill(Color.BLACK);
                optD.setTextFill(Color.BLACK);
                guess = ' ';
                index++;
                loadQuestion();
            }
        }));
        pause.setCycleCount(1);
        pause.play();
    }

    public void opt3clicked(ActionEvent e) {
        guess = 'C';
        if(checkAnswer(guess)) {}
        optB.setTextFill(Color.RED);
        optA.setTextFill(Color.RED);
        optD.setTextFill(Color.RED);
        Timeline pause = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                optA.setTextFill(Color.BLACK);
                optB.setTextFill(Color.BLACK);
                optC.setTextFill(Color.BLACK);
                optD.setTextFill(Color.BLACK);
                guess = ' ';
                index++;
                loadQuestion();
            }
        }));
        pause.setCycleCount(1);
        pause.play();
    }

    public void opt4clicked(ActionEvent e) {
        guess = 'D';
        if(checkAnswer(guess)) {}
        optB.setTextFill(Color.RED);
        optC.setTextFill(Color.RED);
        optA.setTextFill(Color.RED);
        Timeline pause = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                optA.setTextFill(Color.BLACK);
                optB.setTextFill(Color.BLACK);
                optC.setTextFill(Color.BLACK);
                optD.setTextFill(Color.BLACK);
                guess = ' ';
                index++;
                loadQuestion();
            }
        }));
        pause.setCycleCount(1);
        pause.play();
    }
}