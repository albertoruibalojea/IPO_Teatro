package controlador;



import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;


public class ControladorInicio implements Initializable {

    @FXML
    private BorderPane BorderpaneGlobal;

    @FXML
    private GridPane gridPaneStart;

    @FXML
    private JFXButton btnFunciones;

    @FXML
    private JFXButton btnMusica;

    @FXML
    private JFXButton btnPeques;

    @FXML
    private JFXButton btnBaile;

    @FXML
    void pressBtnBaile(ActionEvent event) {
    	try {
    		Parent NuevoBaile = FXMLLoader.load(getClass().getResource("/vista/baile.fxml"));
    		Stage Baile = new Stage();
    		Baile.setTitle("Ventana Baile");
    		Baile.setScene(new Scene(NuevoBaile));
    		Baile.show();
    		Baile.setMinHeight(500);
    		Baile.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();
    				
    	}catch(Exception r){
    		System.out.println("Fallo en: " +r);
    	}
    }

    @FXML
    void pressBtnFunciones(ActionEvent event) {
    	try {
    		Parent NuevaFuncion = FXMLLoader.load(getClass().getResource("/vista/teatro.fxml"));
    		Stage Funcion = new Stage();
    		Funcion.setTitle("Ventana Funciones");
    		Funcion.setScene(new Scene(NuevaFuncion));
    		Funcion.show();
    		Funcion.setMinHeight(500);
    		Funcion.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();
    				
    	}catch(Exception r){
    		System.out.println("Fallo en: " +r);
    	}

    }

    @FXML
    void pressBtnMusica(ActionEvent event) {
    	try {
    		Parent NuevaMusica = FXMLLoader.load(getClass().getResource("/vista/musica.fxml"));
    		Stage Musica = new Stage();
    		Musica.setTitle("Ventana Música");
    		Musica.setScene(new Scene(NuevaMusica));
    		Musica.show();
    		Musica.setMinHeight(500);
    		Musica.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();
    				
    	}catch(Exception r){
    		System.out.println("Fallo en: " +r);
    	}
    }

    @FXML
    void pressBtnPeques(ActionEvent event) {
    	try {
    		Parent NuevoPeques = FXMLLoader.load(getClass().getResource("/vista/peques.fxml"));
    		Stage Peque = new Stage();
    		Peque.setTitle("Ventana Peques");
    		Peque.setScene(new Scene(NuevoPeques));
    		Peque.show();
    		Peque.setMinHeight(500);
    		Peque.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();
    				
    	}catch(Exception r){
    		System.out.println("Fallo en: " +r);
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    


}
