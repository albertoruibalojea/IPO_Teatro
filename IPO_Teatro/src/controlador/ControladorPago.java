package controlador;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPago implements Initializable {
    private String entradas;
    @FXML
    private JFXButton btnFinalizar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private Text precio;

    @FXML
    private Text labelPago;

    @FXML
    private JFXButton btnAtras;

    @FXML
    private Label titulo;

    @FXML
    private Text fecha;

    @FXML
    public void setVariables(String titulo, String fecha, String precio, String pago, String entradas){
        this.titulo.setText(titulo);
        this.fecha.setText(fecha);
        this.precio.setText(precio);
        this.labelPago.setText(pago);
        this.entradas = entradas;
    }

    @FXML
    void irAtras(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        this.abrirAnterior();
    }

    @FXML
    void abrirAnterior() throws IOException {
        String archivo = "";
        if(this.titulo.getText().equalsIgnoreCase("La Vida es Sueño"))
            archivo = "/vista/compraVidasueno.fxml";
        else if(this.titulo.getText().equalsIgnoreCase("Xuncos"))
            archivo = "/vista/compraXuncos.fxml";
        else if(this.titulo.getText().equalsIgnoreCase("Dumbo. El Musical"))
            archivo = "/vista/compraDumbo.fxml";
        else if(this.titulo.getText().equalsIgnoreCase("Cascanueces"))
            archivo = "/vista/compraCascanueces.fxml";


        Parent root = FXMLLoader.load(getClass().getResource(archivo));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/start.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void finalizar(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/vista/finalizar.fxml"));
        try{
            Loader.load();
        } catch (IOException e){
            Logger.getLogger(ControladorCompra.class.getName()).log(Level.SEVERE, null, e);
        }

        ControladorFin display = Loader.getController();
        display.setVariables(this.entradas);

        Parent p = Loader.getRoot();
        Stage Compra = new Stage();
        Compra.setScene(new Scene(p));
        Compra.setTitle("Compra realizada con éxito");
        Compra.show();
        Compra.setMinHeight(500);
        Compra.setMinWidth(750);
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setLabelPago(Text labelPago) {
        this.labelPago = labelPago;
    }

    public void setPrecio(Text precio) {
        this.precio = precio;
    }
}
