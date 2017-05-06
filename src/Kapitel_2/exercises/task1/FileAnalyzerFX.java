package Kapitel_2.exercises.task1;/**
 * Created by tilli_000 on 26.02.2017.
 */

import com.sun.deploy.xml.XMLable;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileAnalyzerFX extends Application {

    public static final Double LABEL_WIDTH = 60.0;

    TextField txtLines;
    TextField txtWords;
    TextField txtCharacters;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        Label txtInfo = new Label("");

        Button btnAnalyze = new Button("Analyze");
        btnAnalyze.setOnAction((event) -> {
            // Button was clicked, do something...
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(primaryStage);
            txtInfo.setText("");
            try {
                generateStatistic(file);
            }catch(Exception e){
                txtInfo.setText("Error While Parsind File!");
            }
        });



        HBox hboxCharacters = new HBox();
        Label lblCharacters = new Label("Characters");
        lblCharacters.setMinWidth(LABEL_WIDTH);
        txtCharacters = new TextField();
        hboxCharacters.getChildren().addAll(lblCharacters,txtCharacters);

        HBox hboxWords = new HBox();
        Label lblWords = new Label("Words");
        lblWords.setMinWidth(LABEL_WIDTH);
        txtWords = new TextField();
        hboxWords.getChildren().addAll(lblWords,txtWords);

        HBox hboxLines = new HBox();
        Label lblLines = new Label("Lines");
        lblLines.setMinWidth(LABEL_WIDTH);
        lblLines.setMinWidth(60);
        txtLines = new TextField();
        hboxLines.getChildren().addAll(lblLines,txtLines);


        vbox.getChildren().addAll(btnAnalyze,txtInfo, hboxCharacters,hboxWords,hboxLines);

        primaryStage.setScene(new Scene(vbox,300,600));
        primaryStage.show();

    }

    private void generateStatistic(File file) throws Exception{

        FileReader reader = new FileReader(file);
        Scanner in = new Scanner(reader);
        //Characters
        int characters = 0;
        int nbrLines = 0;
        int words = 0;
        while(in.hasNextLine()){
            nbrLines ++;
            String line = in.nextLine();
            characters += line.length();
            words += new StringTokenizer(line, " ").countTokens();

        }
        txtCharacters.setText(String.valueOf(characters));
        txtLines.setText(String.valueOf(nbrLines));
        txtWords.setText(String.valueOf(words));

    }
}
