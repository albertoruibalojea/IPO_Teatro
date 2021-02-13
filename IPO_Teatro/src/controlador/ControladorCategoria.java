package controlador;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorCategoria implements Initializable {

    @FXML
    private ImageView btnCancelar;

    @FXML
    private JFXButton btnFunciones;


    @FXML
    void irAtras(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        this.abrirAnterior();
    }

    @FXML
    void abrirAnterior() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/start.fxml"));
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void abrirError(ActionEvent event){
        try {
            Parent Error = FXMLLoader.load(getClass().getResource("/vista/error.fxml"));
            Stage VentanaError = new Stage();
            VentanaError.setTitle("Oops, ha surgido un error.");
            VentanaError.setScene(new Scene(Error));
            VentanaError.show();
            VentanaError.setMinHeight(350);
            VentanaError.setMinWidth(500);

        }catch(Exception r){
            System.out.println("Fallo en: " +r);
        }
    }

    @FXML
    void pressBtnTeatro(ActionEvent event) {
        try {
            Parent NuevoTeatro = FXMLLoader.load(getClass().getResource("/vista/funcionVidasueno.fxml"));
            Stage Teatro = new Stage();
            Teatro.setTitle("La Vida es Sueño");
            Teatro.setScene(new Scene(NuevoTeatro));
            Teatro.show();
            Teatro.setMinHeight(500);
            Teatro.setMinWidth(750);
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }catch(Exception r){
            System.out.println("Fallo en: " +r);
        }
    }

    @FXML
    void pressBtnPeques(ActionEvent event) {
        try {
            Parent NuevoPeques = FXMLLoader.load(getClass().getResource("/vista/funcionDumbo.fxml"));
            Stage Peque = new Stage();
            Peque.setTitle("Dumbo. El Musical");
            Peque.setScene(new Scene(NuevoPeques));
            Peque.show();
            Peque.setMinHeight(500);
            Peque.setMinWidth(750);
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }catch(Exception r){
            System.out.println("Fallo en: " +r);
        }
    }

    @FXML
    void pressBtnMusica(ActionEvent event) {
        try {
            Parent NuevoXuncos = FXMLLoader.load(getClass().getResource("/vista/funcionXuncos.fxml"));
            Stage Xuncos = new Stage();
            Xuncos.setTitle("Xuncos");
            Xuncos.setScene(new Scene(NuevoXuncos));
            Xuncos.show();
            Xuncos.setMinHeight(500);
            Xuncos.setMinWidth(750);
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }catch(Exception r){
            System.out.println("Fallo en: " +r);
        }
    }

    @FXML
    void pressBtnBaile(ActionEvent event) {
        try {
            Parent NuevoBaile = FXMLLoader.load(getClass().getResource("/vista/funcionCascanueces.fxml"));
            Stage Baile = new Stage();
            Baile.setTitle("Cascanueces");
            Baile.setScene(new Scene(NuevoBaile));
            Baile.show();
            Baile.setMinHeight(500);
            Baile.setMinWidth(750);
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }catch(Exception r){
            System.out.println("Fallo en: " +r);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}