package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorFin implements Initializable {
    @FXML
    private AnchorPane panel;

    @FXML
    private Text entradas;


    @FXML
    void salir(MouseEvent event) {
        try {
            Parent Login = FXMLLoader.load(getClass().getResource("/vista/lockScreen.fxml"));
            Stage Inicio = new Stage();
            Inicio.setTitle("Ventana Peques");
            Inicio.setScene(new Scene(Login));
            Inicio.show();
            Inicio.setMinHeight(500);
            Inicio.setMinWidth(750);
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setVariables(String entradas){
        this.entradas.setText(entradas);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
