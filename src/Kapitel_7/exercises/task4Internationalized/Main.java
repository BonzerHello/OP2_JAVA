package Kapitel_7.exercises.task4Internationalized;

import Kapitel_7.examples.clickMe.SimpleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create an FXMLLoader instance based on the fxml file 
			FXMLLoader loader = new FXMLLoader(getClass().getResource("international.fxml"));
						
			// Set Controller explicitly (fx:controller must be removed from FXML!)
			loader.setController(new InternationalController());

			// Create the node hierarchy by calling load
			Parent root = (Parent) loader.load();
			
			Scene scene = new Scene(root);
			// Set Stylesheet
			setUserAgentStylesheet(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("I18n EasterExample");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
