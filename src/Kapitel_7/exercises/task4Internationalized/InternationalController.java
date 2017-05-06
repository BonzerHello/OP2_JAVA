package Kapitel_7.exercises.task4Internationalized;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by tilli_000 on 07.04.2017.
 */
public class InternationalController {

    @FXML
    private Label labelFirstLine;

    @FXML
    private Label labelSecondLine;

    @FXML
    private Label labelThirdLine;



    public InternationalController(){

    }


    @FXML
    protected void handleClickMe(ActionEvent event) {

        labelFirstLine.setText("Erster");
        labelSecondLine.setText("Zweiter");
        labelThirdLine.setText("Dritter");

    }
}
