package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    	try {
			Parent Login = FXMLLoader.load(getClass().getResource("/vista/lockScreen.fxml"));
			primaryStage.setTitle("Teatro Principal de Pontevedra");
			primaryStage.setScene(new Scene(Login));
			primaryStage.show();
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(750);
			primaryStage.setMaxHeight(500);
			primaryStage.setMaxWidth(750);

		} catch(Exception e) {
			e.printStackTrace();
		}
    }


    public static void main(String[] args) {
        launch(args);
    }
}
