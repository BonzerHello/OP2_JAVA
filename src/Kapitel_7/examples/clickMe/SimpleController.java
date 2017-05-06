package Kapitel_7.examples.clickMe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class SimpleController {

	private int counterA = 0;
	private int counterB = 0;

	@FXML
	private Label messageA;

	@FXML
	private Label messageB;

	@FXML
	protected void handleClickMeA(ActionEvent event) {
		counterA ++;
		this.messageA.setText(String.valueOf(counterA));

	}
	@FXML
	protected void handleClickMeB(ActionEvent event) {
		counterB ++;
		this.messageB.setText(String.valueOf(counterB));

	}
}
