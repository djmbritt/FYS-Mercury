package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.models.Bagage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
    public void zoekAction(ActionEvent event) {
        System.out.println("zoeken ");
        List<StringProperty> parameters = new ArrayList();

        parameters = setParameters(parameters);
        if (parameters.size() > 0) {
            List<Bagage> results = BagageDAO.zoekBagage(parameters);
            for (Bagage stuk : results) {
                System.out.println(stuk.toString());
            }
        }

    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        bagageType.getItems().addAll("", "Bag",
                "Case",
                "Box");
        bagageType.getSelectionModel().selectFirst();
        primaireKleur.getItems().addAll("", "Black",
                "Lightgray",
                "Red");
        primaireKleur.getSelectionModel().selectFirst();
        secundaireKleur.getItems().addAll("", "Cream",
                "Lightgray",
                "Lightgray");
        secundaireKleur.getSelectionModel().selectFirst();

    }

    private List<StringProperty> setParameters(List<StringProperty> parameters) {
        parameters.add(new SimpleStringProperty(vluchtnummer, "ArrivedWithFlight", vluchtnummer.getText()));
        System.out.println(vluchtnummer.getText());
        parameters.add(new SimpleStringProperty(merk, "BrandMerk", merk.getText()));
        System.out.println(merk.getText());
        parameters.add(new SimpleStringProperty(locatie_gevonden, "LocatieGevonden", locatie_gevonden.getText()));
        System.out.println(locatie_gevonden.getText());
        parameters.add(new SimpleStringProperty(formaat, "formaat", formaat.getText()));
        System.out.println(formaat.getText());
        parameters.add(new SimpleStringProperty(labelNummer, "BagageLabel", labelNummer.getText()));
        System.out.println(labelNummer.getText());
        parameters.add(new SimpleStringProperty(bagageType, "BagageType", bagageType.getValue().toString()));
        System.out.println(bagageType.getValue().toString());
        parameters.add(new SimpleStringProperty(primaireKleur, "MainColor", primaireKleur.getValue().toString()));
        System.out.println(primaireKleur.getValue().toString());
        parameters.add(new SimpleStringProperty(secundaireKleur, "SecondColor", secundaireKleur.getValue().toString()));
        System.out.println(secundaireKleur.getValue().toString());
        return checkIfFieldEmpty(parameters);

    }

    private List<StringProperty> checkIfFieldEmpty(List<StringProperty> parameters) {
        System.out.println("Parameters Size: " + parameters.size());
        List<StringProperty> itemsToDelete = new ArrayList();
        for (int i = 0; i < parameters.size(); i++) {
            System.out.println(i);
            System.out.println(parameters.get(i).getName());
            if (parameters.get(i).getValue().trim().length() == 0) {
                System.out.println(parameters.get(i).getName());
                itemsToDelete.add(parameters.get(i));
            }
        }
        parameters.removeAll(itemsToDelete);
        System.out.println("Parameters Size: " + parameters.size());

        return parameters;
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
