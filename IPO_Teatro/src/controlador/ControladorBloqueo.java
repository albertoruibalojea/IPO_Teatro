package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.print.DocFlavor;

import app.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorBloqueo implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void pressScreen(MouseEvent event) {
        try {
            Parent NuevaPrincipal = FXMLLoader.load(getClass().getResource("/vista/start.fxml"));
            Stage Principal = new Stage();
            Principal.setTitle("Ventana Principal");
            Principal.setScene(new Scene(NuevaPrincipal));
            Principal.show();
            Principal.setMinHeight(500);
            Principal.setMinWidth(750);
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }catch(Exception r){
            System.out.println("Fallo en: " +r);
        }
    }
}
