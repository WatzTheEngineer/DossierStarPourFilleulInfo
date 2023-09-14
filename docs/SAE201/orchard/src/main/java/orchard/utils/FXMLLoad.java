package orchard.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLLoad {
	public void loadFXMLFile(String path, Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource(path));
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setFullScreen(false);
		stage.setScene(scene);

		stage.show();
	}

}
