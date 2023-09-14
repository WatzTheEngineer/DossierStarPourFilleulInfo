package orchard.utils;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import orchard.model.Orchard;

public class DisplayPopup {
	
	public static void displayWinPopup(Orchard orchard) {
		Alert endOfGame = new Alert(AlertType.INFORMATION);
		endOfGame.setTitle("Game is over");
		endOfGame.setHeaderText("You win !");
		endOfGame.setContentText("You win in " + orchard.getPlayer().getTurnNumber() + " turns.");
		endOfGame.showAndWait();
		Platform.exit();
	}
	
	public static void displayLosePopup(Orchard orchard) {
		Alert endOfGame = new Alert(AlertType.INFORMATION);
		endOfGame.setTitle("Game is over");
		endOfGame.setHeaderText("You lose !");
		endOfGame.setContentText("You lost in " + orchard.getPlayer().getTurnNumber() + " turns.");
		endOfGame.showAndWait();
		Platform.exit();
	}

}
