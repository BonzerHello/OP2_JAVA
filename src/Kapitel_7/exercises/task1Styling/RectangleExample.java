package Kapitel_7.exercises.task1Styling;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class RectangleExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			final StackPane stack = new StackPane();
			Rectangle rect = new Rectangle(100,100); 
			rect.getStyleClass().add("my-rect"); 
			stack.getChildren().addAll(rect); 

			Scene scene = new Scene(stack); 
			scene.getStylesheets().add(getClass().getResource("rectangle2.css").toExternalForm());
			
			primaryStage.setTitle("Rectangle");
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
