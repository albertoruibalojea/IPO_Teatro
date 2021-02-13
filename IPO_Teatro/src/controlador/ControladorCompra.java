package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorCompra implements Initializable {
    @FXML
    private JFXButton btnSiguiente;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXComboBox<String> comboAsientos;

    @FXML
    private JFXRadioButton entradaPapel;

    @FXML
    private ToggleGroup grupoEntrada;

    @FXML
    private JFXRadioButton entradaMovil;

    @FXML
    private TextField movil;

    @FXML
    private JFXRadioButton pagoTarjeta;

    @FXML
    private ToggleGroup grupoPago;

    @FXML
    private JFXRadioButton pagoMovil;

    @FXML
    private Text precio;

    @FXML
    private Spinner<Integer> entradas;

    @FXML
    private Label titulo;

    @FXML
    private Text fecha;

    @FXML
    private Label encabezado;

    private ObservableList<String> dbTypeList = FXCollections.observableArrayList("Palco (20€)","Butacas (15€)","Louge (30€)");


    @FXML
    void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/start.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void enableMovil(ActionEvent event) {
        if(entradaMovil.isSelected())
            this.movil.setDisable(false);
        else this.movil.setDisable(true);
    }

    @FXML
    void calcularPrecio(ActionEvent event) {
        String Asiento = comboAsientos.getValue();
        int precioAsiento = 0;
        if(Asiento.equalsIgnoreCase("Palco (20€)"))
            precioAsiento = 20;
        else if(Asiento.equalsIgnoreCase("Butacas (15€)"))
            precioAsiento = 15;
        else if(Asiento.equalsIgnoreCase("Louge (30€)"))
            precioAsiento = 30;

        if(precioAsiento !=0) {
            int total = precioAsiento * entradas.getValue();
            precio.setText(Integer.toString(total));
        } else System.out.println("Error calculando precio.");
    }

    @FXML
    void irPago(ActionEvent event) {
        if(this.getTipoEntrada() != 0){
            if(this.getTipoPago() != 0){
                try {
                    boolean ok = false;
                    String tipoPago = "", tipoEntrada = "";
                    String precioDado = this.precio.getText();
                    if(this.getTipoPago() != 0) {
                        if (this.getTipoPago() == 1) tipoPago = "Acerca la tarjeta al lector";
                        else if (this.getTipoPago() == 2) tipoPago = "Acerca tu móvil al lector";

                        if (this.getTipoEntrada() != 0) {
                            if (this.getTipoEntrada() == 1) {
                                tipoEntrada = "Recoge tu entrada en la ranura";
                                ok = true;
                            } else if (this.getTipoEntrada() == 2 && !this.movil.getText().isEmpty()) {
                                tipoEntrada = "La entrada se ha enviado al móvil " + this.movil.getText();
                                ok = true;
                            } else this.abrirError(event);
                        }

                        if(ok) {
                            FXMLLoader Loader = new FXMLLoader();
                            Loader.setLocation(getClass().getResource("/vista/pago.fxml"));
                            try {
                                Loader.load();
                            } catch (IOException e) {
                                Logger.getLogger(ControladorCompra.class.getName()).log(Level.SEVERE, null, e);
                            }

                            ControladorPago display = Loader.getController();
                            display.setVariables(this.titulo.getText(), this.fecha.getText(), precioDado, tipoPago, tipoEntrada);

                            Parent p = Loader.getRoot();
                            Stage Compra = new Stage();
                            Compra.setScene(new Scene(p));
                            Compra.setTitle("Pago de entradas");
                            Compra.show();
                            Compra.setMinHeight(500);
                            Compra.setMinWidth(750);
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                        }
                    }


                }catch(Exception r){
                    System.out.println("Fallo en: " +r);
                }
            } else this.abrirError(event);
        } else this.abrirError(event);
    }

    //Devuelve 1 si es física, 2 si es en el móvil
     public Integer getTipoEntrada(){
        if(this.entradaPapel.isSelected()) return 1;
        else if(this.entradaMovil.isSelected()) return 2;

        return 0;
     }

    //Devuelve 1 si es física, 2 si es en el móvil
    public Integer getTipoPago(){
        if(this.pagoTarjeta.isSelected()) return 1;
        else if(this.pagoMovil.isSelected()) return 2;

        return 0;
    }

    public Text getPrecio() {
        return precio;
    }

    @FXML
    void abrirError(ActionEvent event){
        try {
            Parent Error = FXMLLoader.load(getClass().getResource("/vista/errorPago.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboAsientos.setItems(dbTypeList);
        comboAsientos.getSelectionModel().select(1);

        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        entradas.setValueFactory(valueFactory);


        precio.setText("15");

    }

}
