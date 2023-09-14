package orchard.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import orchard.utils.FXMLLoad;
import orchard.utils.FXMLPath;

public class OrchardMain extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoad fxmlLoad = new FXMLLoad();
		fxmlLoad.loadFXMLFile(FXMLPath.MAINPAGE.path(), stage);

	}

	public static void main(String[] args) {
		launch(args);

	}

}
