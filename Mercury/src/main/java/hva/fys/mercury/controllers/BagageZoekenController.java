package hva.fys.mercury.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BagageZoekenController implements Initializable {

    @FXML
    private TextField vluchtnummer;
    @FXML
    private TextField merk;
    @FXML
    private TextField locatie_gevonden;
    @FXML
    private TextField formaat;
    @FXML
    private TextField labelNummer;

    @FXML
    private ComboBox bagageType;
    @FXML
    private ComboBox primaireKleur;
    @FXML
    private ComboBox secundaireKleur;

    @FXML
    private void zoekAction(ActionEvent event) {
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }
}
