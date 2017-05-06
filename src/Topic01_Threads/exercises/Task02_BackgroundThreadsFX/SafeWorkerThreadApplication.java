package Topic01_Threads.exercises.Task02_BackgroundThreadsFX;/**
 * Created by tilli_000 on 02.05.2017.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class SafeWorkerThreadApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setMinHeight(200);
        Button btn1 = new Button("Wait 5 seconds");
        Button btn2 = new Button("Say \'Hi\'");
        Button btn3 = new Button("Cancel");
        VBox root = new VBox(textArea,new HBox(btn1,btn3,btn2));

        btn1.setOnAction((ActionEvent event) ->{
            new Thread(() -> {
                Platform.runLater(() ->{
                    btn1.setDisable(true);
                    textArea.appendText("Waiting ...\n");
                });
                try{
                    Thread.sleep(5000);
                }catch(Exception e){}
                Platform.runLater(() ->{
                    textArea.appendText("5 seconds are over!\n");
                    btn1.setDisable(false);
                });
            }).start();

        });

        btn2.setOnAction((ActionEvent event) ->{
            textArea.appendText("Hi!\n");
        });

        Scene scene = new Scene(root,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
