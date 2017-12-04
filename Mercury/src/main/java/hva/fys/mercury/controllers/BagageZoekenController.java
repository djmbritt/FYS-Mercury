package hva.fys.mercury.controllers;

import hva.fys.mercury.models.Bagage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent; 
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BagageZoekenController implements Initializable {

    @FXML
    private TextField vluchtnummer;
    private TextField merk;
    private TextField locatie_gevonden;
    private TextField formaat;
    private TextField labelNummer;
    
    @FXML 
    private ComboBox bagageType;
    private ComboBox primaireKleur;
    private ComboBox secundaireKleur;

    @FXML
    private void zoekAction(ActionEvent event) {
        List<StringProperty> parameters = new ArrayList();
        
//          ObservableList<Bagage> observableList = FXCollections.observableList(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

//    private List<StringProperty> getParameters(){
//        
//        List<StringProperty> parameters = new ArrayList();
//        parameters.add(new SimpleStringProperty(merk, name, initialValue))
//    }
    
    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }
}
