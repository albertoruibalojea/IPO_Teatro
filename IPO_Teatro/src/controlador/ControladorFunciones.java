package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ControladorFunciones implements Initializable{
	@FXML
	private ImageView btnCancelar;

	@FXML
	private JFXButton btnCompra;

	@FXML
	private Label encabezado;


	@FXML
	void irAtras(ActionEvent event) throws IOException {
		((Node)(event.getSource())).getScene().getWindow().hide();
		this.abrirAnterior();
	}

	@FXML
	void abrirAnterior() throws IOException {
		String archivo = "";
		if(this.encabezado.getText().equalsIgnoreCase("FUNCIONES TEATRALES"))
			archivo = "/vista/teatro.fxml";
		else if(this.encabezado.getText().equalsIgnoreCase("FUNCIONES MUSICALES"))
			archivo = "/vista/musica.fxml";
		else if(this.encabezado.getText().equalsIgnoreCase("PARA LOS/AS PEQUES"))
			archivo = "/vista/peques.fxml";
		else if(this.encabezado.getText().equalsIgnoreCase("BAILE"))
			archivo = "/vista/baile.fxml";


		Parent root = FXMLLoader.load(getClass().getResource(archivo));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void pulsarBtnCompraXuncos(ActionEvent event){
		try {
			Parent CompraXuncos = FXMLLoader.load(getClass().getResource("/vista/compraXuncos.fxml"));
			Stage Compra = new Stage();
			Compra.setTitle("Compra de entradas: Xuncos");
			Compra.setScene(new Scene(CompraXuncos));
			Compra.show();
			Compra.setMinHeight(500);
			Compra.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();

		}catch(Exception r){
			System.out.println("Fallo en: " +r);
		}
	}

	@FXML
	void pulsarBtnCompraVidasueno(ActionEvent event){
		try {
			Parent CompraVidasueno = FXMLLoader.load(getClass().getResource("/vista/compraVidasueno.fxml"));
			Stage Compra = new Stage();
			Compra.setTitle("Compra de entradas: La Vida es Sueño");
			Compra.setScene(new Scene(CompraVidasueno));
			Compra.show();
			Compra.setMinHeight(500);
			Compra.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();

		}catch(Exception r){
			System.out.println("Fallo en: " +r);
		}
	}

	@FXML
	void pulsarBtnCompraDumbo(ActionEvent event){
		try {
			Parent CompraDumbo = FXMLLoader.load(getClass().getResource("/vista/compraDumbo.fxml"));
			Stage Compra = new Stage();
			Compra.setTitle("Compra de entradas: Dumbo. El Musical");
			Compra.setScene(new Scene(CompraDumbo));
			Compra.show();
			Compra.setMinHeight(500);
			Compra.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();

		}catch(Exception r){
			System.out.println("Fallo en: " +r);
		}
	}

	@FXML
	void pulsarBtnCompraCascanueces(ActionEvent event){
		try {
			Parent CompraCascanueces = FXMLLoader.load(getClass().getResource("/vista/compraCascanueces.fxml"));
			Stage Compra = new Stage();
			Compra.setTitle("Compra de entradas: Cascanueces");
			Compra.setScene(new Scene(CompraCascanueces));
			Compra.show();
			Compra.setMinHeight(500);
			Compra.setMinWidth(750);
			((Node)(event.getSource())).getScene().getWindow().hide();

		}catch(Exception r){
			System.out.println("Fallo en: " +r);
		}
	}

	@Override
    public void initialize(URL location, ResourceBundle reosurces) {
    //add controlador para tomar solo el nombre(comprobar si cada caracter es un espacio y cuando lo sea cortar el string ahi).    
	}
}