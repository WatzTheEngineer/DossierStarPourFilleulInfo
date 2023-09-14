package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TestJavaFXbis extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			BorderPane pane = new BorderPane();
			BorderPane subPane = new BorderPane();
			GridPane grid = new GridPane();
			Scene scene = new Scene(pane,600,320);
			
			pane.setPadding(new Insets(5, 5, 5, 5));
			subPane.setPadding(new Insets(5, 5, 5, 5));
			grid.setVgap(10);
			grid.setHgap(10);
			
			Text mainText = new Text("Souscrivez à notre newsletter !");
			mainText.setUnderline(true);
			BorderPane.setAlignment(mainText, Pos.TOP_CENTER);
			pane.setTop(mainText);
			
			pane.setCenter(new Text("Bienvenue à notre newsletter, inscrivez-vous pour avoir des nouvelles"));
			
			pane.setBottom(subPane);

			subPane.setTop(grid);
			
			ComboBox<String> cb = new ComboBox<>();
			Label cbLabel = new Label("Civilité");
			cb.getItems().add("M.");
			cb.getItems().add("Mme.");
			cb.getSelectionModel().select(0);
			grid.add(cbLabel, 0, 0);
			grid.add(cb, 0, 1);
			
			TextField tf = new TextField();
			TextField tf2 = new TextField();
			Label tfLabel = new Label("Nom");
			Label tf2Label = new Label("Prénom");
			grid.add(tfLabel, 0, 2);
			grid.add(tf2Label, 1, 2);
			grid.add(tf, 0, 3);
			grid.add(tf2, 1, 3);
			
			TextField tf3 = new TextField();
			TextField tf4 = new TextField();
			Label tf3Label = new Label("Adresse email");
			Label tf4Label = new Label("Confirmez votre email");
			grid.add(tf3Label, 0, 4);
			grid.add(tf4Label, 1, 4);
			grid.add(tf3, 0, 5);
			grid.add(tf4, 1, 5);
			
			CheckBox choice = new CheckBox("J'accepte les conditions générales d'utilisation de la newsletter.");
			grid.add(choice, 0, 6);
			
			Button btn = new Button();
			BorderPane.setAlignment(btn, Pos.CENTER);
			btn.setText("Souscrire");
			subPane.setCenter(btn);
			
			Text botText = new Text("Utilisateur non inscrit");
			BorderPane.setAlignment(botText, Pos.CENTER);
			subPane.setBottom(botText);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Application Newsletter");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
