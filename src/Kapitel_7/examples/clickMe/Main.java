package Kapitel_7.examples.clickMe;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create an FXMLLoader instance based on the fxml file 
			FXMLLoader loader = new FXMLLoader(getClass().getResource("View2.fxml"));
						
			// Set Controller explicitly (fx:controller must be removed from FXML!)
			loader.setController(new SimpleController());

			// Create the node hierarchy by calling load
			Parent root = (Parent) loader.load();
			
			Scene scene = new Scene(root);
			// Set Stylesheet
			setUserAgentStylesheet(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Click Me Example");
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
