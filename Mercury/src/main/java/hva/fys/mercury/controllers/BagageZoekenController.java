package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.DAO.DatabaseManager;
import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Bagage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class BagageZoekenController implements Initializable, ParentControllerContext {

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
    private AnchorPane bagageInformatie;
    @FXML
    private AnchorPane bagageResultaten;
    @FXML
    private GridPane zoekParam;
    @FXML
    private BagageResultatenController bagageResultatenController;
    @FXML
    private BagageInformatieController bagageInformatieController;

    @FXML
    public void zoekAction(ActionEvent event) {

        BagageDAO dbBagage = new BagageDAO();
        System.out.println("zoeken ");
        List<StringProperty> parameters = new ArrayList();

        parameters = setParameters(parameters);
        if (parameters.size() > 0) {
            List<Bagage> results = dbBagage.zoekBagage(parameters);

            bagageResultatenController.refreshTable();
            bagageResultatenController.fillTable(results);
            bagageResultatenController.setParentContext(this);
            showResults();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setBagageTypeBox();
        setKleurBox();

    }

    private void setKleurBox() {
        DatabaseManager dbman = new DatabaseManager(MainApp.DATABASE_NAME);
        List<String> kleuren = new ArrayList();
        kleuren.add("");
        String query = "Select * From kleuren";
        try {
            ResultSet rs = dbman.executeResultSetQuery(query);
            while (rs.next()) {
                kleuren.add(rs.getString("Engels"));
            }

            dbman.close();
        } catch (SQLException ex) {
            Logger.getLogger(BagageZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaireKleur.getItems().addAll(kleuren);
        primaireKleur.getSelectionModel().selectFirst();
        secundaireKleur.getItems().addAll(kleuren);
        secundaireKleur.getSelectionModel().selectFirst();
    }

    private void setBagageTypeBox() {
        DatabaseManager dbman = new DatabaseManager(MainApp.DATABASE_NAME);
        List<String> types = new ArrayList();
        types.add("");
        String query = "Select * From bagagetypes";
        try {
            ResultSet rs = dbman.executeResultSetQuery(query);
            while (rs.next()) {
                types.add(rs.getString("Engels"));
            }

            dbman.close();
        } catch (SQLException ex) {
            Logger.getLogger(BagageZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bagageType.getItems().addAll(types);
        bagageType.getSelectionModel().selectFirst();
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

    private void showSearchForm() {
        bagageResultaten.setVisible(false);
        zoekParam.setVisible(true);
    }

    private void showResults() {
        bagageResultaten.setVisible(true);
        zoekParam.setVisible(false);
    }

    private void showBagageDetails() {

        bagageResultaten.setVisible(false);
        zoekParam.setVisible(false);
        bagageInformatie.setVisible(true);
    }

    @Override
    public void notifyCloseChild() {
        showSearchForm();
    }

    @Override
    public void notifyChildHasUpdated() {
        showResults();
    }

    @Override
    public void displayStatusMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transferObject(Object ob) {
        Bagage bag = (Bagage) ob;
        System.out.println("In transferOpbject= " + bag);
        System.out.println("BagageInformatieController= " + bagageInformatieController);
        bagageInformatieController.setFields(bag);
        showBagageDetails();
    }

}
